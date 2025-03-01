// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

import "@openzeppelin/contracts/token/ERC721/extensions/ERC721URIStorage.sol";
import "@openzeppelin/contracts/access/Ownable.sol";

contract Scamft is ERC721URIStorage, Ownable {

    uint256 private _currentToken = 0;

    constructor() Ownable(msg.sender) ERC721("42Scamft", "SFT") {}

    function mintScamft(address to, string memory uri) public {
        _safeMint(to, _currentToken);
        _setTokenURI(_currentToken, uri);
        _currentToken++;
    }
}