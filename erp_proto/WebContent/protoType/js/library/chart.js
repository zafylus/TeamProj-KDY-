let data = [];
			let colorArray = ["red", "orange", "yello", "yellogreen", "green", "blue", "purple"];
			for (let i = 0; i < ctgyData.length; i++) {
				let item = ctgyData[i];
				let colorArr = colorArray[i];
				data.push({ key: item.category, value: item.saleCnt, color: colorArr });
			}
			let chart = new Chart();
			chart.setData(data);