// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

import "@openzeppelin/contracts/token/ERC721/extensions/ERC721URIStorage.sol";
import "@openzeppelin/contracts/access/Ownable.sol";

contract WordContract is ERC721URIStorage, Ownable {
    struct TokenData {
        address owner;
        string word;
    }

    uint256 private _currentToken = 0;

    mapping(uint256 => TokenData) public tokenBook;
    mapping(string => bool) public usedWords;

    mapping(address => bool) public canSign;

    mapping(uint256 => address[]) public approvalBook;
    mapping(uint256 => bool) public waitForApproval;


    constructor() Ownable(msg.sender) ERC721("42Word", "WRD") {
        canSign[msg.sender] = true;
    }

    function addSigner(address _signerToAdd) public onlyOwner {
        canSign[_signerToAdd] = true;
    }

    function signToken(uint256 _token) public {
        require(canSign[msg.sender], "You are not allowed to sign");
        require(waitForApproval[_token], "No approval needed for this token");

        approvalBook[_token].push(msg.sender);
    }

    function approveToken(uint256 _token) public  {
        require(canSign[msg.sender], "You are not allowed to approve");
        require(waitForApproval[_token], "No approval needed for this token");
        require(approvalBook[_token].length >= 2, "This token don't have enough sign");

        waitForApproval[_token] = false;
    }

    function mintToken(string memory _newWord) public {
        require(!usedWords[_newWord], "This word is already claim");

        tokenBook[_currentToken] = TokenData({owner: msg.sender, word: _newWord });
        usedWords[_newWord] = true;
        waitForApproval[_currentToken] = true;
    }

    function finalizeMint(uint256 _token) public {
        require(tokenBook[_token].owner == msg.sender, "You are not the owner of this token");
        require(!waitForApproval[_token], "This token is not approved.");

        _safeMint(msg.sender, _token);
        delete waitForApproval[_token];
        _currentToken++;
    }

    function getWordData(uint _token) public view returns (address owner, string memory word) {
        owner = tokenBook[_token].owner;
        word = tokenBook[_token].word;
    }

    function getWaitForApproval(uint _token) public view returns (bool value) {
        value = waitForApproval[_token];
    }

    function getSignNumber(uint _token) public view returns (uint256 value) {
        value = approvalBook[_token].length;
    }
}