// document.getElementById('getData').onclick = getData;
document.getElementById('getData').addEventListener("click", getData);

/*
    - When button is clicked, send http request to API for a specific id
    - get the id value from input box
    - send request to PokeAPI
        - Method: GET
        - Headers: None
        - Body: None
        - url: https://pokeapi.co/api/v2/pokemon/ + id from input box
    - might have to convert JSON to JS object
    - populate the data in Section
*/
let baseApiURL = 'https://pokeapi.co/api/v2/pokemon';

async function getData() {
    console.log('Button was clicked!');
    let id = document.getElementById('dataInput').value;
    console.log(`id = ${id}`);

    let httpResponse = await fetch(`${baseApiURL}/${id}`);

    if(httpResponse.status >= 200 && httpResponse.status < 300){ //........ what?
    let data = await httpResponse.json();

    populateData(data);
    
    } else {
        console.log('Invalid request.');
    }
}

function populateData(response) {

    //document element selectors
    const dataPopDiv = document.createElement('div');
    const dataPopPara = document.createElement('p');

    //document element creators
    const content = document.createTextNode(response); //we need to chekc if we can't get less infos from this!

    //element appending(s)
    dataPopPara.appendChild(content);
    dataPopDiv.appendChild(dataPopPara);

    const doc = document.getElementById('getData');
    doc.appendChild(dataPopDiv);

    console.log(response);
}

// document.body.onload = addElement;

// function addElement() {
//   // create a new div element
//   const newDiv = document.createElement("div");

//   // and give it some content
//   const newContent = document.createTextNode("Hi there and greetings!");

//   // add the text node to the newly created div
//   newDiv.appendChild(newContent);

//   // add the newly created element and its content into the DOM
//   const currentDiv = document.getElementById("div1");
//   document.body.insertBefore(newDiv, currentDiv);
// }
