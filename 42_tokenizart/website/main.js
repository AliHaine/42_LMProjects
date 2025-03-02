const contractAddress = "0xd2F3403e85Ca936bFf7ca7B79Ec09952D8944E12";
const provider = new ethers.providers.Web3Provider(window.ethereum);
let signer, contract;

main();

async function main() {
    await provider.send("eth_requestAccounts", []);
    signer = provider.getSigner();
}


function mintCall() {

}