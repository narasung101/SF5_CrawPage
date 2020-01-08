"use strict"
var app = app || {}

app = (() => {
	const WHEN_ERROR = '호출하는 js 파일을 찾을 수 없습니다.'
	let _, css, img, js, auth_js
	let run = x => $.getScript(x + '/resources/js/cmm/router.js',
		() => {$.extend(new Session(x))
						onCreate()
		})

	let init = () => {
		_ = $.ctx()
		css = $.css()
		img = $.img()
		js = $.js()
		auth_js = js + '/cmm/auth.js'
	}
	let onCreate = () => {
		init()
		$.when(
			$.getScript(auth_js)
		)
		.done(() => {
			auth.onCreate()
		 })
		.fail(() => {
			alert(WHEN_ERROR)
		})
	}
	
	return {run}
})()
