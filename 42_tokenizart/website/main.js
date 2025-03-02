const contractAddress = "0xd2F3403e85Ca936bFf7ca7B79Ec09952D8944E12";
const provider = new ethers.providers.Web3Provider(window.ethereum);
let signer, contract;

const ABI = [
    {
        "type": "function",
        "name": "mintScamft",
        "stateMutability": "nonpayable",
        "inputs": [
            { "type": "address", "name": "to" },
            { "type": "string", "name": "uri" }
        ],
        "outputs": [ ]
    },
    {
        "type": "function",
        "name": "ownerOf",
        "stateMutability": "view",
        "inputs": [
            { "type": "uint256", "name": "tokenId" }
        ],
        "outputs": [
            { "type": "address", "name": "" }
        ]
    }
    ]

main();

async function main() {
    await provider.send("eth_requestAccounts", []);
    signer = provider.getSigner();
    contract = new ethers.Contract(contractAddress, ABI, signer);
}


async function mintCall() {
    event.preventDefault();
    const address = document.getElementById("address").value;
    const uri = document.getElementById("uri").value;
    if (!address || !uri)
        return;
    try {
        const result = await contract.mintScamft(address, uri);
        console.log(result);
        document.getElementById("out").textContent = result;
    } catch (e) {
        document.getElementById("out").textContent = "Error " + e.message;
    }
}

async function mintCallInchain() {
    event.preventDefault();
    const address = document.getElementById("address").value;
    const uri = document.getElementById("uri").value;
    if (!address || !uri)
        return;
    try {
        const result = await contract.mintScamft(address, uri);
        console.log(result);
        document.getElementById("out").textContent = result;
    } catch (e) {
        document.getElementById("out").textContent = "Error " + e.message;
    }
}

async function viewCall(event) {
    event.preventDefault();
    const tokenId = document.getElementById("view-target-token").value;
    if (!tokenId || tokenId < 0)
        return;
    try {
        const owner = await contract.ownerOf(tokenId);
        console.log(owner);
        document.getElementById("out").textContent = owner;
    } catch (e) {
        document.getElementById("out").textContent = "No owner found";
    }
}

async function viewIpfsCall(event) {
    event.preventDefault();
    const ipfs = document.getElementById("view-target-ipfs").value;
    if (!ipfs)
        return;
    window.open("https://ipfs.io/ipfs/" + ipfs, '_blank').focus();
}