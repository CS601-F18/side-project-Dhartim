package cs601.sideproject;
/**
 * JaVaScriptElement - Interface that holds autocomplete JS code
 * @author dhartimadeka
 *
 */
public interface JavaScriptElements {
	
	String JS_AUTOCOMPLETE = 
			"<script>\r\n" + 
			"function autocomplete(inp, arr) {\r\n" + 
		//inp - textfield value and arr- list of key from inverted index
		 	"  var currentFocus;\r\n" +  
		 	//executes wen something writtern in textbox
			"  inp.addEventListener(\"input\", function(e) {\r\n" +  
			"      var a, b, i, val = this.value;\r\n" + 
			//closes any openn list of autocomplete 
			"      closeAllLists();\r\n" +  
			"      if (!val) { return false;}\r\n" +  //if nothing in textfield den  return false and set focus to -1
			"      currentFocus = -1;\r\n" + //set focus to -1
			 
			 //this div will contain list of values or keyset
			"      a = document.createElement(\"DIV\");\r\n" + 
			"      a.setAttribute(\"id\", this.id + \"autocomplete-list\");\r\n" + 
			"      a.setAttribute(\"class\", \"autocomplete-items\");\r\n" + 
			// append it inside div container
			"      this.parentNode.appendChild(a);\r\n" +   
			//check each elements from list of values
			"      for (i = 0; i < arr.length; i++) {\r\n" +  
			//check if watever typed start's with same value 
			"        if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {\r\n" + 
			        //if matched den make div element of it 
			"          b = document.createElement(\"DIV\");\r\n" + 
			"          /*make the matching letters bold:*/\r\n" + 
			"          b.innerHTML = \"<strong>\" + arr[i].substr(0, val.length) + \"</strong>\";\r\n" +  //make that matched letter bold
			"          b.innerHTML += arr[i].substr(val.length);\r\n" + 
			"          /*insert a input field that will hold the current array item's value:*/\r\n" + 
			"          b.innerHTML += \"<input type='hidden' value='\" + arr[i] + \"'>\";\r\n" + //insert those elements into input 
			//field with matching elements in it
			"          /*execute a function when someone clicks on the item value (DIV element):*/\r\n" + 
						// executed when someone clicks on list of words found after matching
			"          b.addEventListener(\"click\", function(e) {\r\n" + 
			"              /*insert the value for the autocomplete text field:*/\r\n" + 
						//insert value for autocomplete text field
			"              inp.value = this.getElementsByTagName(\"input\")[0].value;\r\n" + 
			"              /*close the list of autocompleted values,\r\n" + 
			"              (or any other open lists of autocompleted values:*/\r\n" + 
						//close list of values
			"              closeAllLists();\r\n" + 
			"          });\r\n" + 
			//append list of matching words into div id created before
			"          a.appendChild(b);\r\n" + 
			"        }\r\n" + 
			"      }\r\n" + 
			"  });\r\n" + 
			"  /*execute a function presses a key on the keyboard:*/\r\n" + 
			//execute it when keypressed on keyboard
			"  inp.addEventListener(\"keydown\", function(e) {\r\n" + 
			// 
			"      var x = document.getElementById(this.id + \"autocomplete-list\");\r\n" + 
			"      if (x) x = x.getElementsByTagName(\"div\");\r\n" + 
				// when arrow down key is pressed
			"      if (e.keyCode == 40) {\r\n" + 
			"        /*If the arrow DOWN key is pressed,\r\n" + 
			"        increase the currentFocus variable:*/\r\n" + 
			"        currentFocus++;\r\n" +  //current focus is increased
			"        /*and and make the current item more visible:*/\r\n" + 
				//make item visible
			"        addActive(x);\r\n" + 
			//wen key pressed up
			"      } else if (e.keyCode == 38) { //up\r\n" +  
			 //decrease current focus
			"        currentFocus--;\r\n" + 
			//adjust visibility accordingly
			"        addActive(x);\r\n" +  
			"      } else if (e.keyCode == 13) {\r\n" +  //wen enter key pressed
			 //to prevent from form submission and select item from list
			"        e.preventDefault();\r\n" + 
			"        if (currentFocus > -1) {\r\n" +  
					//click on item which is active
			
			"          if (x) x[currentFocus].click();\r\n" +  
			"        }\r\n" + 
			"      }\r\n" + 
			"  });\r\n" + 
			//to know which item is more active and wen to show autocomplete
			"  function addActive(x) {\r\n" + 
			"    if (!x) return false;\r\n" + 
			"    /*start by removing the \"active\" class on all items:*/\r\n" + 
			"    removeActive(x);\r\n" +  
			"    if (currentFocus >= x.length) currentFocus = 0;\r\n" + 
			"    if (currentFocus < 0) currentFocus = (x.length - 1);\r\n" + 
			"    /*add class \"autocomplete-active\":*/\r\n" + 
			"    x[currentFocus].classList.add(\"autocomplete-active\");\r\n" + 
			"  }\r\n" + 
			"  function removeActive(x) {\r\n" + 
			//remove class autocomplete active
			"    for (var i = 0; i < x.length; i++) {\r\n" + 
			"      x[i].classList.remove(\"autocomplete-active\");\r\n" + 
			"    }\r\n" + 
			"  }\r\n" + 
				//close all elements in autocomplete list
			"  function closeAllLists(elmnt) {\r\n" +
			"    var x = document.getElementsByClassName(\"autocomplete-items\");\r\n" + 
			"    for (var i = 0; i < x.length; i++) {\r\n" + 
			"      if (elmnt != x[i] && elmnt != inp) {\r\n" + 
			"        x[i].parentNode.removeChild(x[i]);\r\n" + 
			"      }\r\n" + 
			"    }\r\n" + 
			"  }\r\n" + 
			"  /*execute a function when someone clicks in the document:*/\r\n" + 
			"  document.addEventListener(\"click\", function (e) {\r\n" + 
			"      closeAllLists(e.target);\r\n" + 
			"  });\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			//pass keyslist
			"var wordList = JSON.parse('{keysetauto}');\r\n" + 
			"\r\n" + 
			//initiate autocomplete
			"autocomplete(document.getElementById(\"myInput\"), wordList);\r\n" + 
			"</script>";

}
