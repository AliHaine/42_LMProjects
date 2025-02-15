// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

import "@openzeppelin/contracts/token/ERC721/extensions/ERC721URIStorage.sol";

contract WordContract is ERC721URIStorage {
    uint256 private currentToken = 0;

    mapping(address => string) public userWords;
    string[] public ownedWords;

    address[] public signers;

    constructor() public ERC721("42Word", "WRD") {
        signers.push(msg.sender);
    }

    function addSigner(address _signerToAdd) public onlyOwner {
        signers.push(_signerToAdd);
    }

    function mintToken(string memory _newWord) public {
        ownedWords.cont
    }

    function finalizeMint() public {

    }
}