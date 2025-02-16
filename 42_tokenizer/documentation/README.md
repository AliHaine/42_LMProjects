# Variables

    //Will track wich token correspond to which word.
    struct TokenData {
        address owner;
        string word;
    }

    //current token index
    uint256 private _currentToken = 0;

    //Link a token to a TokenData
    mapping(uint256 => TokenData) public tokenBook;
    //Guard to prevent duplicate word claim
    mapping(string => bool) public usedWords;

    //List of address which can sign token
    mapping(address => bool) public canSign;

    //Act as historic for each token, and also check if a token have enough signs
    mapping(uint256 => address[]) public approvalBook;
    //Check if a token need a approval 
    mapping(uint256 => bool) public waitForApproval;

# Getter

    //Get the owner and word of the target token
    function getWordData(uint _token) public view returns (address owner, string memory word) {
        owner = tokenBook[_token].owner;
        word = tokenBook[_token].word;
    }

    //Get if a token need an approval
    function getWaitForApproval(uint _token) public view returns (bool value) {
        value = waitForApproval[_token];
    }

    //Get the actual number of signs of the target token
    function getSignNumber(uint _token) public view returns (uint256 value) {
        value = approvalBook[_token].length;
    }

# Methods

    //Try to sign the target token, require to be in the canSign map and the token must need being approved
    function signToken(uint256 _token) public {
        require(canSign[msg.sender], "You are not allowed to sign");
        require(waitForApproval[_token], "No approval needed for this token");

        approvalBook[_token].push(msg.sender);
    }

    //Try to approve a token if the token have the amount of signs (2), only a signer can approve
    function approveToken(uint256 _token) public  {
        require(canSign[msg.sender], "You are not allowed to approve");
        require(waitForApproval[_token], "No approval needed for this token");
        require(approvalBook[_token].length >= 2, "This token don't have enough sign");

        waitForApproval[_token] = false;
    }

    //init the mint process, link the word to the token, and add the token to the wait for approval map
    function mintToken(string memory _newWord) public {
        require(!usedWords[_newWord], "This word is already claim");

        tokenBook[_currentToken] = TokenData({owner: msg.sender, word: _newWord });
        usedWords[_newWord] = true;
        waitForApproval[_currentToken] = true;
    }

    //Finalize the mint, need to be the token owner and the token need to be approved 
    function finalizeMint(uint256 _token) public {
        require(tokenBook[_token].owner == msg.sender, "You are not the owner of this token");
        require(!waitForApproval[_token], "This token is not approved.");

        _safeMint(msg.sender, _token);
        delete waitForApproval[_token];
        _currentToken++;
    }