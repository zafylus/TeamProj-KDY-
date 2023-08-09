	
	
		let navs = document.querySelectorAll(".nav");
		let sides = document.querySelectorAll(".side_btn");
		let sub = document.querySelectorAll(".sub_box");

		// nav css

		//side css 
		for (var index = 0; index < sides.length; index++) {
			sides[index].addEventListener("focus", focus_side);
			sides[index].addEventListener("blur", blur_side);
		};


	  // 각 nav 요소에 클릭 이벤트를 추가합니다.
	  	navs.forEach(nav => {
	    nav.addEventListener('click', function() {
      // 클릭한 nav 요소에 active 클래스를 추가합니다.
      	this.classList.add('active');

      // 나머지 nav 요소들에서 active 클래스를 제거하고 해당 nav의 sub_box를 감춥니다.
	    navs.forEach(otherNav => {
	        if (otherNav !== this) {
	          otherNav.classList.remove('active');
	          otherNav.nextElementSibling.style.display = 'none';
	        }
	      });

	      const subBox = this.nextElementSibling;
	      subBox.style.display = 'flex';
	    });
	  });
	document.addEventListener('click', function(event) {
	  const target = event.target;
	  // 클릭한 요소가 nav가 아니라면 모든 sub_box를 감춥니다.
	  if (!target.classList.contains('nav')) {
	    sub.forEach(subBox => {
	      subBox.style.display = 'none';
	  	});
	 navs.forEach(nav => {
	      nav.classList.remove('active');
	    });
	 }
	});
		// side
		function focus_side(e) {
			let target = e.target;
			target.style.color = "#4da6ff";
			target.style.background = "#f0f0ff";
			
			
			
		}
		function blur_side(e) {
			let target = e.target;
			target.style.color = "#4e4e4e";
			target.style.background = "white";
		}
		