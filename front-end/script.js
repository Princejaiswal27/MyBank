// Create Customer

document.getElementById("customerForm").addEventListener("submit", async function(event) {
    event.preventDefault();
    let customerName = document.getElementById("customerName").value;
    let address = document.getElementById("address").value;

    let response = await fetch('http://localhost:8090/customers', {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ customerName, address })
    });

    let data = await response.json();
    document.getElementById("message").innerText = "Customer Created: " + data.customerName;
});

//Open Account
document.getElementById("accountForm").addEventListener("submit", async function(event) {
    event.preventDefault();    
    let customerId = document.getElementById("customer_Id").value;  // Get the customer ID from input.
    let balance = document.getElementById("initialBalance").value;
	document.getElementById("message").innerText = `Customer ID: ${customerId}`;
 
    let response = await fetch(`http://localhost:8090/accounts/open`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ customerId, balance })
    });

    let data = await response.json();
    document.getElementById("message").innerText = `Account Opened for Customer ID: ${customerId}, Account Number: ${data.accountNumber}`;
});


// Check Balance
async function checkBalance() {
    let accountNumber = prompt("Enter account number:");
	if(!accountNumber){
		alert("Please enter an account number.");
		return;
	}
    let response = await fetch(`http://localhost:8090/accounts/balance/${accountNumber}`);
    let balance = await response.text();
    document.getElementById("message").innerText = `Balance:" + $${balance}`;
}

// Perform Credit/Debit
async function performTransaction(type) {
    let accountNumber = prompt("Enter account number:");
    let amount = prompt('Enter amount to ${type}:');

    let response = await fetch(`http://localhost:8090/accounts/${type}/${accountNumber}/${amount}`, {
        method: "POST"
    });

    let message = await response.text();
    document.getElementById("message").innerText = message;
}