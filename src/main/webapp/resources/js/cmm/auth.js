var auth = auth || {}
auth = (() => {
	const WHEN_ERR = '호출하는 JS파일을 찾을 수 없습니다.'
	let _, js, auth_vue_js, brd_js, brd_vue_js
	let init = () => {
		_ = $.ctx()
		js = $.js()
		auth_vue_js = js + '/vue/auth_vue.js'
		brd_js = js + '/cmm/brd.js'
		brd_vue_js = js + '/vue/brd_vue.js'
	}
	let onCreate = () => {
		init()
		$.when(
			$.getScript(auth_vue_js)
		).done(() => {
				setContentView()
				$('#a_join').click(e=>{
					alert('a조인 버튼 클릭 ')
					e.preventDefault()
					$('body').html(auth_vue.join())

					$('#btn_join').click(e => {
						alert('조인 버튼 클릭 ')
						e.preventDefault
						join()

					})

				})

			})
			.fail(() => {
				alert(WHEN_ERR)

			})

	}
	let setContentView = () => {
		$('body').html(auth_vue.login())
		login()
	}

	let join = () => {
		alert('join 들어옴')
		$.ajax({
			url: _ + '/customers/',
			type: 'POST',
			dataType: 'json',
			data: JSON.stringify({
				uid: $('#join_uid').val(),
				upw: $('#join_upw').val()
			}),
			contentType: 'application/json',
			success: data => {
				alert('AJAX성공')
				if (data.msg === 'success') {
					$('body').html(auth_vue.login())
					login()
				} else {
					alert('회원가입 실패')
				}

			},
			error: e => {
				alert('AJAX 실패')
			}

		})

	}
	let login = () => {

		$('#btn_login').click(e=> {
			e.preventDefault()
		
			$.ajax({
				url: _+'/customers/'+$('#login_uid').val(),
				type: 'POST',
				dataType: 'json',
				data: JSON.stringify({
					uid: $('#login_uid').val(),
					upw: $('#login_upw').val()
				}),
				contentType: 'application/json',
				success: d => {
					
					brd.onCreate()
				},
				error: e => {
					alert('AJAX 실패')
				}

			})
		})

	}
	return {onCreate}
})();