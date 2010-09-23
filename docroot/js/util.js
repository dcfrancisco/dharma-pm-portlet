
	function selectAll() {
		for (var i = 0; i < messageIds.length; i++) {
			document.getElementById("message_" + messageIds[i]).checked = !allSelected;
		}
		allSelected = !allSelected;
	}

	function selectAllBlockedUsers() {
		for (var i = 0; i < blockedUserIds.length; i++) {
			document.getElementById("blocked_user_" + blockedUserIds[i]).checked = !allSelected;
		}
		allSelected = !allSelected;
	}
	
	function getSelectedMessages() {
		var entries = "";
		for (var i = 0; i < messageIds.length; i++) {
			var obj = document.getElementById("message_" + messageIds[i]);
			if (obj.checked) {
				entries += messageIds[i] + ";";
			}
		}
		if(entries == "") {
			alert("Please select messages");
			return false;
		}
		document.getElementById('ids').value = entries;
		return true;
	}
	
	function eraseSelectedMessages() {
		var entries = "";
		for (var i = 0; i < messageIds.length; i++) {
			var obj = document.getElementById("message_" + messageIds[i]);
			if (obj.checked) {
				entries += messageIds[i] + ";";
			}
		}
		if(entries == "") {
			alert("Please select messages");
			return false;
		}
		document.getElementById('type').value = 'erase';
		document.getElementById('ids').value = entries;
		return true;
	}

	function getSelectedUsers() {
		var entries = "";
		for (var i = 0; i < messageIds.length; i++) {
			var obj = document.getElementById("message_" + messageIds[i]);
			if (obj.checked) {
				entries += userIds[i] + ";";
			}
		}
		if(entries == "") {
			alert("Please select users");
			return false;
		}
		document.getElementById('type').value = 'block';
		document.getElementById('ids').value = entries;
		return true;
	}
	
	function getSelectedBlockedUsers() {
		var entries = "";
		for (var i = 0; i < blockedUserIds.length; i++) {
			var obj = document.getElementById("blocked_user_" + blockedUserIds[i]);
			if (obj.checked) {
				entries += blockedUserIds[i] + ";";
			}
		}
		if(entries == "") {
			alert("Please select users");
			return false;
		}
		document.getElementById('ids').value = entries;
		return true;
	}	
	
	function openCompose() {
		location.href = composeURL;
	}

	function addUser() {
		var from = document.getElementById("select_from");
		if(from.disabled) {
			return;
		}
		var to = document.getElementById("select_to");
		var toRemove = new Array();

		//	if All Users Selected then disable other options
		for(var i=0; i<from.options.length; i++) {
			if(from.options[i].selected && from.options[i].value == allUsers) {
				to.options.length = 0;
				var newElem = document.createElement("option");
				newElem.text = from.options[i].text;
				newElem.value = from.options[i].value;
				to.options.add(newElem);
				
				loadAllUsers();

				from.disabled = true;

				removeOption("select_from", newElem.value);

				return;
			}
		}

		for(var i=0; i<from.options.length; i++) {
			if(from.options[i].selected) {
				var newElem = document.createElement("option");
				newElem.text = from.options[i].text;
				newElem.value = from.options[i].value;
				to.options.add(newElem);

				toRemove.push(newElem.value);
			}
		}

		for(var i=0; i<toRemove.length; i++) {
			removeOption("select_from", toRemove[i]);
		}
		
		sortListbox("select_from");
		sortListbox("select_to");
	}

	function removeUser() {
		var to = document.getElementById("select_from");
		var from = document.getElementById("select_to");
		var toRemove = new Array();

		for(var i=0; i<from.options.length; i++) {
			if(from.options[i].selected) {
				var newElem = document.createElement("option");
				newElem.text = from.options[i].text;
				newElem.value = from.options[i].value;
				to.options.add(newElem);

				toRemove.push(newElem.value);
				
				to.disabled = false;
			}
		}
		for(var i=0; i<toRemove.length; i++) {
			removeOption("select_to", toRemove[i]);
		}
		
		sortListbox("select_from");
		sortListbox("select_to");
	}

	function dh_onSubmit() {
		cleanErrors();

		var str = "";
		var to = document.getElementById("select_to");
		if(to) {
			for(var i=0; i<to.options.length; i++) {
				str += to.options[i].value + ";";
			}
			if(str == "") {
				showError("Recepients not selected");
				return false;
			}
			document.getElementById("recepients").value = str;

			if(document.getElementById("subject").value == "") {
				showError("Subject cannot be empty");
				return false;
			}

			if(document.getElementById("body").value == "") {
				showError("Message body cannot be empty");
				return false;
			}
		}

		return true;
	}
	
	function removeRecepient(id) {
		document.getElementById("recepient_" + id).style.display = "none";
		var str = document.getElementById("recepients").value;
		str = str.replace(id, "");
		document.getElementById("recepients").value = str;
		return false;
	}

	function cleanErrors() {
		document.getElementById("error_div").innerHTML = "";
		document.getElementById("error_div").style.display = "none";
	}
	
	function showError(msg) {
		document.getElementById("error_div").innerHTML = msg;
		document.getElementById("error_div").style.display = "block";
		window.scroll(0, 0);
	}

	function removeOption(objId, str) {
		var obj = document.getElementById(objId);
		for(var i=0; i<obj.options.length; i++) {
			if(obj.options[i].value == str) {
				obj.remove(i);
				return;
			}
		}
	}
	
	function dh_replyTo(messageId) {
		document.getElementById("replyId").value = messageId;
		document.getElementById("reply_form").submit();
		return false;
	}
	
	function dh_delete(messageId) {
		if(confirm('Delete this message ?')) {
			document.getElementById("ids").value = messageId + ";";
			document.getElementById("delete_form").submit();
		}
		return false;
	}
	
	function showLeftSymbols() {
		var maxCount = 10000;
		var enteredValue = document.getElementById('body').value;
		var enteredCount = enteredValue.length;
		if (enteredCount > maxCount) {
			document.getElementById('body').value = enteredValue.substring(0, maxCount);
		} else {
			var count = 1*(maxCount - enteredCount);
			document.getElementById('chars_left').innerHTML = count + " characters left";
			if(count < 0) {
				document.getElementById('chars_left').style.color = "red";
			} else {
				document.getElementById('chars_left').style.color = "blue";
			}
		}
		return true;
	}

	function updateUsersBox() {
		loadAllUsers();

		var str = document.getElementById("find").value.toLowerCase();
		if(str != "") {
			var from = document.getElementById("select_from");
			var toRemove = new Array();
			for(var i=0; i<from.options.length; i++) {
				if(from.options[i].text.toLowerCase().indexOf(str) == -1) {
					toRemove.push(from.options[i].value);
				}
			}
			for(var i=0; i<toRemove.length; i++) {
				from = document.getElementById("select_from");
				removeOption("select_from", toRemove[i]);
			}
		}
	}
	
	function isAllUsersSelected() {
		var obj = document.getElementById("select_to");
		for(var i=0; i<obj.options.length; i++) {
			if(obj.options[i].value == allUsers) {
				return true;
			}
		}
		return false;
	}

	function alreadySelected(str) {
		var obj = document.getElementById("select_to");
		for(var i=0; i<obj.options.length; i++) {
			if(obj.options[i].text == str) {
				return true;
			}
		}
		return false;
	}

	function addUserToList(name, id) {
		var to = document.getElementById("select_to");
		for(var i=0; i<to.options.length; i++) {
			if(to.options[i].text == name) {
				return;
			}
		}
		var from = document.getElementById("select_from");
		var newElem = document.createElement("option");
		newElem.text = name;
		newElem.value = id;
		from.options.add(newElem);
	}

	function replyToAll() {
		document.getElementById("select_to").options.length = 0;
		loadAllUsers();
		var names = replyToAllStr.split(", ");
		var from = document.getElementById("select_from");
		for(var i=0; i<from.options.length; i++) {
			for(var j=0; j<from.options.length; j++) {
				if(from.options[j].text == names[i]) {
					from.options[j].selected = true;
					break;
				}
			}
		}
		addUser();
		return true;
	}

	function sortListbox(id) {
		var lb = document.getElementById(id);
		var arrTexts = new Array();
		var arrValues = new Array();
		var arrOldTexts = new Array();

		for(i=0; i<lb.length; i++) {
			arrTexts[i] = lb.options[i].text;
			arrValues[i] = lb.options[i].value;	
			arrOldTexts[i] = lb.options[i].text;
		}

		arrTexts.sort();

		for(i=0; i<lb.length; i++) {
			lb.options[i].text = arrTexts[i];
			for(j=0; j<lb.length; j++) {
				if (arrTexts[i] == arrOldTexts[j]) {
					lb.options[i].value = arrValues[j];
					j = lb.length;
				}
			}
		}
	}
