# Setup

You will need :
- A wallet to store your crypto and NFT. I chose Metamask
- An IDE to code, compile and deploy a contract. I chose RemixIDE
- Some SepoliaETH which is a crypto used for tests, you can get free Sepolia by several way easily on internet
- Some assets to mint and the associated meta data (yml)
- Something to interact with IPFS network, for example Filbase or run IPFS https://github.com/ipfs/ipfs-desktop#ipfs-desktop

# IPFS

IPFS (Inter Planetary File System), is the best way to manage NFT an meta data files. IPFS work with a peer-to-peer logic.
What mean there is no a central server which manage every files, instead, each user act as client and server in the same time.

# Contract 

You will need a contract to mint your NFT ("link" the assets to a wallet), to do that, I have code a simple contract, then I compiled it and deployed it on a blockchain
using RemixIDE. You can interact with the contract at the address 0xd2F3403e85Ca936bFf7ca7B79Ec09952D8944E12

# Code

According to the subject, I use the ERC721 standards

    import "@openzeppelin/contracts/token/ERC721/extensions/ERC721URIStorage.sol";

I declare a private variable which is initialized to 0, this variable will represent the token

    uint256 private _currentToken = 0;

In the constructor, I call ERC721 to create a smart contract based on ERC721 standards 

    constructor() ERC721("42Scamft", "SFT") {}

Then, you can see the main function mintScamft, which is used to mint a new NFT for the given address and the provided uri

    function mintScamft(address to, string memory uri) public {
        _safeMint(to, _currentToken);
        _setTokenURI(_currentToken, uri);
        _currentToken++;
    }
