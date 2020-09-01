function displayProducts() {
    const req = new XMLHttpRequest();
    req.onreadystatechange = () => {
        // Example Handle Logic
        if (req.status === 200 && req.readyState === 4) {
            console.log("nice" + req.readyState);
            if (req.getResponseHeader("Content-Type") === "application/json") {
                console.log("successful response JSON: " + req.responseText);


                let stuff = JSON.parse(req.response);
                stuff.forEach(el => {
                    console.log("oh look its some JSON: " + req.responseText);
                    let divElement = document.getElementsByClassName("row");
                    // adding title to the body of the page
                    let column = document.createElement('div')// create column item
                    let attCol= document.createAttribute("class");// Create a "class" attribute
                    attCol.value = "col-sm-4";// Set the value of the class attribute
                    column.setAttributeNode(attCol);

                    // set values
                    el.product.forEach(product => {
                        console.log(product) // print all notes for each notebook

                        let panel = document.createElement('div')// new panel item
                        let attPan  = document.createAttribute("class");// Create a "class" attribute
                        attPan.value = "panel panel-success";// Set the value of the class attribute
                        panel.setAttributeNode(attPan);
                        let title = document.createElement('div'); // new title
                        let attTitle  = document.createAttribute("class");       // Create a "class" attribute
                        attTitle.value = "panel-heading";// Set the value of the class attribute
                        title.setAttributeNode(attTitle);
                        let description = document.createElement('div');// new description -> i want this to b
                        let attDes  = document.createAttribute("class");// Create a "class" attribute
                        attDes.value = "panel-body";// Set the value of the class attribute
                        panel.setAttributeNode(attDes);
                        let  price = document.createElement('div');
                        let attPrice  = document.createAttribute("class");// Create a "class" attribute
                        attPrice.value = "panel-body";// Set the value of the class attribute
                        panel.setAttributeNode(attPrice);

                        title.textContent = product.title;
                        description.textContent = "Description: " + product.description;
                        price.textContent = "£ " + product.price;
                        divElement.appendChild(column);
                        column.appendChild(panel);
                        panel.appendChild(title);
                        panel.appendChild(description);
                        panel.appendChild(price);
                    })
                    document.div.appendChild(divElement);
                });
            } else {
                console.log(
                    "Looks like its not JSON but lets see what it is... " + req.responseText
                );
            }
        } else {
            console.log("Oh no... handle error");
        }
    }; // append all products
    req.open("GET", "http://localhost:8080/allProducts");
    req.send();
}