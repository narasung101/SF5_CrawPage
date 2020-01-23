var popup = popup || {}
popup = {
		show : ()=>{
			return `
			<div style='width:300px;margin:auto;'>
			<h1 >
			     Hello world!
			</h1>
			<a class="popup-modal" href= "#test-modal">팝업</a >
			</div>
			<div id="test-modal" class= "white-popup-block mfp-hide"
			style=' width: 300px; height : 500px; background-color: white; margin : 0 auto;' >
			     <h1 >팝업 </h1 >
			     <p >여자의 근로는 특별한 보호를 받으며,
			     고용·임금 및 근로조건에 있어서 부당한 차별을 받지 아니한다.
			     행정권은 대통령을 수반으로 하는 정부에 속한다. </p >
			     <p ><a class ="popup" href="#"> 닫기</a></p>
			</div>
					`
		}
}
