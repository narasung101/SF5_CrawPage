"use strict"
var brd = brd || {}
brd = (() => {
	const WHEN_ERR = '호출하는 JS파일을 찾을 수 없습니다.'
	let _, js, brd_vue_js
	let init = () => {
		_ = $.ctx()
		js = $.js()
		brd_vue_js = js + '/vue/brd_vue.js'

	}
	let onCreate = () => {
		init()

		$.when(
			$.getScript(brd_vue_js)
		).done(() => {

			setContentView()
		}).fail(() => {
			alert('실패')

		})
	}
	let setContentView = () => {
		$('body').empty()

		list({ pageSize: 5, nowPage: 0 })

		crawling()
		white()

		$('#btn_list').click(e => {
			e.preventDefault()
			$('#crawlTab').remove()
			$('#tmain').remove()
//			list({ pageSize: 5, nowPage: 0 })
			list({ pageSize: 5, nowPage: 0, option:$('#selectOption').val(), search: $('#search').val() })
		})

	}
	let white = function () {

		$('#btn_brd').click(() => {
			alert('게시판 글쓰기 버튼 클릭')
			//$('body').empty()
			$('body').html(brd_vue.white())
			$('#btn_write').click(e => {
				e.preventDefault()
				alert('글 작성 페이지 글쓰기 버튼 클릭')
				$.ajax({
					url: _ + '/boards/',
					type: 'POST',
					data: JSON.stringify({
						title: $('#write_form input[name="title"]').val(),
						writer: $('#write_form input[name="writer"]').val(),
						content: $('#write_form textarea[name="content"]').val()

					}),
					dataType: 'json',
					contentType: 'application/json',
					success: d => {
						alert('글쓰기 성공')
//						list({ pageSize: 5, nowPage: 0 })
						 list({ pageSize: 5, nowPage: 0, option:$('#selectOption').val(), search: $('#search').val() })

					},
					error: e => {
						alert('AJAX 실패')
					}
				})
			})

		})
	}
	
	let content = function () {

		$('#btn_brd').click(() => {
			alert('게시판 글쓰기 버튼 클릭')
			//$('body').empty()
			$('body').html(brd_vue.white())
			$('#btn_write').click(e => {
				e.preventDefault()
				alert('글 작성 페이지 글쓰기 버튼 클릭')
				$.ajax({
					url: _ + '/boards/',
					type: 'POST',
					data: JSON.stringify({
						title: $('#write_form input[name="title"]').val(),
						writer: $('#write_form input[name="writer"]').val(),
						content: $('#write_form textarea[name="content"]').val()

					}),
					dataType: 'json',
					contentType: 'application/json',
					success: d => {
						alert('글쓰기 성공')
//						list({ pageSize: 5, nowPage: 0 })
						list({ pageSize: 5, nowPage: 0, option:$('#selectOption').val(), search: $('#search').val() })

					},
					error: e => {
						alert('AJAX 실패')
					}
				})
			})

		})
	}

	let list = x => {

		$.getJSON(_ + '/boards/list/'+x.pageSize+'/'+x.nowPage+'/'+x.option+'/'+x.search, d => {
			
			$('body').empty()
			$(`
		<div id="wrapper">
		<h2 id="btn_list">게시글 목록 페이지</h2>
		<h2 id="btn_crawlTest">테스트 크롤링 페이지</h2>
		<h2 id="btn_crawlBugs">벅스 크롤링 페이지</h2>

		<div id="search_form">
		
		</div>

		<table id="tmain" border="1">
			<thead id="thead">
				<tr>
					<th scope="col">#NO</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">등록일</th>
				</tr>
			</thead>
			<tbody id="tbody">
			
			</tbody>
		</table>

		<div id="page_form">
		
		</div>

		<div id="page_size_form">
		
		</div>
				
		<button id ="btn_brd">글쓰기</button>
		<button id ="btn_brd2">삭제</button>
		</div>
		`).appendTo('body')

			$.each(d.list, (i, j) => {
				var tr = $("<tr></tr>").appendTo("#tbody");
				$("<td></td>").text(j.bno).appendTo(tr);
				$("<td></td>").text(j.title).appendTo(tr);
				$("<td></td>").text(j.writer).appendTo(tr);

			})
		
			if (d.pager.existPrev) {
				$(`<span style="border:1px solid black; padding-left: 5px; padding-right: 5px; class="btn-page">이전</span>`)
					.appendTo('#page_form')
					.click((e) => {
						e.preventDefault()
						alert('이전 페이지 클릭' + d.pager.prevBlock)
//						list({pageSize:5, nowPage:d.pager.prevBlock})
						 list({ pageSize: 5, nowPage: 0, option:$('#selectOption').val(), search: $('#search').val() })
					})
			}

			let blocks = []
			for (let i = d.pager.startPage + 1; i <= d.pager.endPage + 1; i++) {
				blocks.push(i)

			}

			$.each(blocks, (i, j) => {
				$(`<span style="border:1px solid black; padding-left: 5px; padding-right: 5px; class="btn-page"><a href="">${j}</a></span>`)
					.appendTo('#page_form')
					.click(function (e) {
						e.preventDefault()
						alert('a링크 클릭' + $(this).text())
//						list({ pageSize: 5, nowPage: (Number($(this).text()) - 1) })
					    list({ pageSize: 5, nowPage: 0, option:$('#selectOption').val(), search: $('#search').val() })

					})
			})
			if (d.pager.existNext) {
				$(`<span style="border:1px solid black; padding-left: 5px; padding-right: 5px; class="btn-page">다음</span>`)
					.appendTo('#page_form')
					.click(function (e) {
						e.preventDefault()
						alert('다음 페이지 클릭' + d.pager.nextBlock)
//						list({ pageSize: 5, nowPage: d.pager.nextBlock })
						 list({ pageSize: 5, nowPage: 0, option:$('#selectOption').val(), search: $('#search').val() })


					})
			}
		
		$(`
		<form>
		페이지 사이즈 입력 <input type="text" id="pageSize" />
		<input id="btn_page_size" type="submit" value="입력" />
		</form>	
		`).appendTo('#page_size_form')
	
		
			$('#btn_page_size').click(e => {
				e.preventDefault()
//				list({ pageSize: $('#pageSize').val(), nowPage: 0 })
				 list({ pageSize: $('#pageSize').val(), nowPage: 0, option:$('#selectOption').val(), search: $('#search').val() })
			})
			
		 $(`
		 <select id="selectOption">
		  <option value="bno">NO</option>
		  <option value="title">제목</option>
		  <option value="writer">작성자</option>
		</select>
		 <form id="search_form">
		 <input type="text" id="search"/>	 </form>	 	 
		 `)
		 .appendTo('#search_form')
		 
		 
		 $(`
		 <input id="btn_page_size-2" type="submit" value="입력"/>
		 `)
		 .appendTo('#search_form')	 
		 .click((e)=>{
			 e.preventDefault()
			 alert('서치' + $('#search').val()+", 옵션:"+$('#selectOption').val())
			 list({ pageSize: 5, nowPage: 0, option:$('#selectOption').val(), search: $('#search').val() })
			
		 })
			
		})
				

	}

	let crawling = () => {


		// $('#btn_crawlTest').click(e => {
		// 	e.preventDefault()
		// 	alert('클릭됨')
		// 	$.getJSON(_ + '/boards/crawl', d => {
		// 		alert('JSON 성공' + d.list)
		// 		$('#tbody').empty()


		// 		$.each(d.list, (i, j) => {

		// 			var tr = $("<tr></tr>").appendTo("#tbody");
		// 			$("<td></td>").text(j).appendTo(tr);

		// 		})

		// 	})
		// })

		$('#btn_crawlBugs').click(e => {
			e.preventDefault()
			alert('클릭됨')
			$('#crawlTab').remove()
			$('<table id="crawlTab"><tr id="crawlTabTr"></tr></table>')
				.css({
					width: '80%',
					height: '800px',
					border: '1px solid black',
					margin: '0 auto'
				})
				.appendTo('body')
			$('<td/>', { id: 'left' })
				.css({
					width: '20%',
					height: '100%',
					border: '1px solid black',
					'vertical-align': 'top'
				})
				.appendTo('#crawlTabTr')
			$('<td/>', { id: 'right' })
				.css({
					width: '80%',
					height: '100%',
					border: '1px solid black',
					'vertical-align': 'top'
				})
				.appendTo('#crawlTabTr')


			$.getJSON(_ + '/boards/crawlBugs', d => {
				console.log(d)
				$('#tmain').remove()
				// $('#thead').empty()
				// $('#tbody').empty()

				$('<table id="content"><tr id="head"></tr></table>')
					.css({ width: '99%', height: '50px', border: '1px solid black' })
					.appendTo('#right')

				$.each(['No.', '제목', '가수', '앨범'], (i, j) => {
					$('<th/>').html('<b>' + j + '</b>')
						.css({
							width: '25%', height: '100%',
							border: '1px solid black'
						})
						.appendTo('#head')
				})


				$.each(d, (i, j) => {
					$('<tr><td>' + j.seq + '</td><td><img src="' + j.thumbnail + '"/></td><td>' + j.title + '</td><td>' + j.artist + '</td></tr>')
						.css({
							width: '25%', heigth: '100%',
							boder: '1px solid black'
						})
						.appendTo('#content tbody')
				})

			})
		})

	}

	return { onCreate }
})();