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
    },
    {
        "type": "function",
        "name": "tokenURI",
        "stateMutability": "view",
        "inputs": [
            { "type": "uint256", "name": "tokenId" }
        ],
        "outputs": [
            { "type": "string", "name": "" }
        ]
    }
    ]

main();

async function main() {
    try {
        await provider.send("eth_requestAccounts", []);
    } catch (error) {
        console.log(error);
    }
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
        await contract.mintScamft(address, uri)
        document.getElementById("out").textContent = "Your NFT is under mining";
    } catch (e) {
        document.getElementById("out").textContent = "Error " + e.message;
    }
}

async function mintCallInchain() {
    event.preventDefault();
    const address = document.getElementById("address-inchain").value;
    const file = document.getElementById("file").files[0];
    if (!address || !file || !document.getElementById("file").value.endsWith(".json"))
        return;

    const toBase64 = file => new Promise(resolve => {
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = () => resolve("base64://" + reader.result.replace("data:application/json;base64,", ""));
        reader.onerror = () => console.log(error);
    });
    const result = await toBase64(file)
    try {
        await contract.mintScamft(address, result);
        document.getElementById("out").textContent = "Your NFT is under mining";
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

async function viewUriCall(event) {
    event.preventDefault();
    const tokenId = document.getElementById("view-target-uri").value;
    if (!tokenId || tokenId < 0)
        return;
    try {
        const owner = await contract.tokenURI(tokenId);
        document.getElementById("out").textContent = owner;
    } catch (e) {
        document.getElementById("out").textContent = "No owner found";
        console.log(e)
    }
}