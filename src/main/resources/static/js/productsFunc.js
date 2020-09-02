function displayProducts() {
    const req = new XMLHttpRequest();
    req.onreadystatechange = () => {
        // Example Handle Logic
        if (req.status === 200 && req.readyState === 4) {

            if (req.getResponseHeader("Content-Type") === "application/json") {

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

                    let image = document.createElement('div');// new description -> i want this to b
                    image.setAttribute("class" + "max-scale", "panel-body" + "fit-content");// Create a "class" attribute

                    let description = document.createElement('div');// new description -> i want this to b
                    description.setAttribute("class", "panel-body");// Create a "class" attribute

                    let price = document.createElement('div');
                    price.setAttribute("class", "panel-footer");// Create a "class" attribute

                    // Set content to respective ids
                    title.textContent = product.title;
                    description.textContent = "Description: " + product.description;
                    price.textContent = "£ " + product.price;
                    let img = new Image();
                    img.src = product.image;

                    // create indented items
                    container.appendChild(divElement);
                    divElement.appendChild(column);
                    column.appendChild(panel);
                    panel.appendChild(title);
                    panel.appendChild(img);
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

function createProduct(){
    let elements = document.getElementById("productForm").elements;
    let obj = {};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    const req = new XMLHttpRequest();
    req.open("POST", "http://localhost:8080/createProduct");
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify({title: obj.title, image: obj.image, description: obj.description, price: obj.price, stock: obj.stock}));
}