console.log('importPage load');	
	
		let navs = document.querySelectorAll(".nav");
		let sides = document.querySelectorAll(".side_btn");
		let sub = document.querySelectorAll(".sub_box");

		// nav css

		//side css 
		for (var index = 0; index < sides.length; index++) {
			sides[index].addEventListener("focus", focus_side);
			sides[index].addEventListener("blur", blur_side);
		};

		// nav
		function focus_nav(e) {
			let target = $(e.target);
			target.css("color", "#1c8dff");
			target.css("borderBottom", "3px solid #1c8dff");
			target.off("mouseout", blur);
		}

		function blur_nav(e) {
			let target = $("e.target");
			target.css("color","#4e4e4e");
			target.css("borderBottom","none");
		}

		// sub
		navs.forEach(function(nav) {
			nav.addEventListener("focus", focus_nav);
			nav.addEventListener("blur", blur_nav);
			nav.addEventListener("blur", function() {
				setTimeout(sub_off, 120);
			});
			nav.addEventListener("focus", function(e) {
				setTimeout(function() {
					sub_on(e.target);
				}, 130);
			});
		});

		// sub
		function sub_on(target) {
			let index = Array.from(navs).indexOf(target);
			sub[index].style.display = "flex";
		}

		function sub_off() {
			sub.forEach(function(subBox) {
				subBox.style.display = "none";
			});
		}

		// side
		function focus_side(e) {
			let target = e.target;
			target.style.color = "#1c8dff";
			target.style.background = "#e6e6ff";
			
			
			
		}
		function blur_side(e) {
			let target = e.target;
			target.style.color = "#4e4e4e";
			target.style.background = "white";
		}
		