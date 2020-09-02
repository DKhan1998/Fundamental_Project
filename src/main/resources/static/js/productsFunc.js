function displayProducts() {
    const req = new XMLHttpRequest();
    req.onreadystatechange = () => {
        // Example Handle Logic
        if (req.status === 200 && req.readyState === 4) {
            console.log("nice" + req.readyState);
            if (req.getResponseHeader("Content-Type") === "application/json") {
                console.log("successful response JSON: " + req.responseText);

                //create elements
                let container = document.createElement('div');
                container.setAttribute("class", "container");
                document.body.appendChild(container);

                let stuff = JSON.parse(req.response);
                stuff.forEach(product => {
                    console.log("oh look its some JSON: " + req.response);
                    //create elements
                    let divElement = document.createElement('div');
                    divElement.setAttribute("class", "row");
                    // adding title to the body of the page
                    let column = document.createElement('div');
                    column.setAttribute("class", "col-sm-4");// create column item

                    let panel = document.createElement('div');// new panel item
                    panel.setAttribute("class", "panel panel-success");// Create a "class" attribute

                    let title = document.createElement('div'); // new title
                    title.setAttribute("class", "panel-heading");       // Create a "class" attribute#

                    let description = document.createElement('div');// new description -> i want this to b
                    description.setAttribute("class", "panel-body");// Create a "class" attribute

                    let price = document.createElement('div');
                    price.setAttribute("class", "panel-footer");// Create a "class" attribute


                    // Set content to respective ids
                    title.textContent = product.title;
                    description.textContent = "Description: " + product.description;
                    price.textContent = "£ " + product.price;

                    // create indented items
                    container.appendChild(divElement);
                    divElement.appendChild(column);
                    column.appendChild(panel);
                    panel.appendChild(title);
                    panel.appendChild(description);
                    panel.appendChild(price);
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