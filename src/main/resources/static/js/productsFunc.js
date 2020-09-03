function displayProducts() {
    const req = new XMLHttpRequest();
    req.onreadystatechange = () => {
        // Example Handle Logic
        if (req.status === 200 && req.readyState === 4) {

            if (req.getResponseHeader("Content-Type") === "application/json") {

                //create elements
                let container = document.createElement('div');
                container.setAttribute("class", "container");
                //create elements
                let row = document.createElement('div');
                row.setAttribute("class", "row");
                document.getElementById("content").appendChild(container);

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
                    image.setAttribute("class", "panel-body");// Create a "class" attribute

                    let description = document.createElement('div');// new description -> i want this to b
                    description.setAttribute("class", "panel-body");// Create a "class" attribute

                    let price = document.createElement('div');
                    price.setAttribute("class", "panel-footer");// Create a "class" attribute

                    let deleteB = document.createElement("button");
                    deleteB.setAttribute("id", "delete");
                    deleteB.setAttribute("class", "button");
                    deleteB.addEventListener("click", function (){
                        deleteProduct(product.id);
                        location.reload();
                    });

                    let updateB = document.createElement("button");
                    updateB.setAttribute("id", "update");
                    updateB.setAttribute("class", "button");
                    updateB.setAttribute("href", "../html/products/update.html");
                    updateB.addEventListener("click", function(){
                        updateGetProduct(product.id);
                    })
                    // Set content to respective ids
                    title.textContent = product.title;
                    description.textContent = "Description: " + product.description;
                    price.textContent = "£ " + product.price;
                    let img = new Image();
                    img.src = product.image;
                    img.setAttribute("width", "200px");
                    img.setAttribute("height", "200px");
                    image.appendChild(img);
                    deleteB.textContent = "DELETE";


                    // create indented items
                    container.appendChild(divElement);
                    divElement.appendChild(column);
                    column.appendChild(panel);
                    panel.appendChild(title);
                    panel.appendChild(image);
                    panel.appendChild(description);
                    panel.appendChild(price);
                    panel.appendChild(deleteB);
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

/*

THIS IS THE CREATE PRODUCT SECTION

 */
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

/*

THIS IS THE DELETE PRODUCT SECTION

 */
function deleteProduct(id){
    const req = new XMLHttpRequest();
    req.open("DELETE", "http://localhost:8080/deleteProduct/" + id);
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.send();
}

/*

THIS IS THE UPDATE PRODUCT SECTION

 */
function updateGetProduct(id){
    const reqGet = new XMLHttpRequest();
    reqGet.open("GET", "http://localhost:8080/getProductById/" + id);
    reqGet.onload = () => {
        if (reqGet.status === 200 && reqGet.readyState === 4) {
                // this loops through the given query
                let product = JSON.parse(reqGet.response);
                product.forEach(field => {
                    console.log("oh look its some JSON: " + req.response);
                   // populate the fields
                    let pTitle = document.getElementById("title");
                    let pPrice = document.getElementById("price");
                    let pFlavour = document.getElementById("image");
                    let pStock = document.getElementById("Stock");
                    let pDesc = document.getElementById("description");
                    let submit = document.getElementById("submit");
                    submit.addEventListener("click", function (){
                        updatePushProduct(field.id);
                        location.reload();
                    });

                    // Set content to respective ids
                    pTitle.textContent = field.title;
                    pPrice.textContent = field.price;
                    pFlavour.getElementsByClassName("value").item(field.image);
                    pStock.textContent = field.stock;
                    pDesc.textContent = "Description: " + field.description;
                });
        } else {
            console.log("Oh no... handle error");
        }
    }; // append all products
    reqGet.send();
}

/*



 */
function updatePushProduct(){
    const req = new XMLHttpRequest();
    req.open("PUT", "http://localhost:8080/updateProduct/" + id);
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
            let elements = document.getElementById("productForm").elements;
            let obj = {};
            for(let i = 0 ; i < elements.length - 1 ; i++){
                let item = elements.item(i);
                obj[item.name] = item.value;
            }
        } else {
            console.log("Oops...");
        }
    };
    req.send();
}