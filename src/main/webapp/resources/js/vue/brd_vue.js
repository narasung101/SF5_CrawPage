var brd_vue = brd_vue || {}
brd_vue = {
	brd_body: () => {
		return `<h1>게시판 리스트</h1>
		
	
	<body>
			
		
	</body>	
		
	`
	},

	white: function () {
		return `<div class="container-fluid" style="width:80%">
		<h1>글 작성</h1>
		<form id="write_form">
		<div>
		<input type="text" name="title" style="margin-top:10px" class="form-control" placeholder="제목" />
		</div>
		<div>
		<input type="text" name="writer" style="margin-top:10px" class="form-control" placeholder="작성자 ID" />
		</div>
		<div class="row">
		<div style="width:97%; margin:10px auto" >
		<textarea name="content" class="form-control" rows="10"></textarea>
		 </div>
		 </div>
		
		<input id="btn_write" name="write" type="submit" class="btn btn-primary"  value="글쓰기"/>
	
	
		<input type="reset" class="btn btn-danger"  value="취소"/>
		
		</div>
		</form>
		</div>`
	},
	
	content: function () {
		return `<div class="container-fluid" style="width:80%">
		<h1>글 작성</h1>
		<form id="write_form">
		<div>
		<input type="text" name="title" style="margin-top:10px" class="form-control" placeholder="제목" />
		</div>
		<div>
		<input type="text" name="writer" style="margin-top:10px" class="form-control" placeholder="작성자 ID" />
		</div>
		<div class="row">
		<div style="width:97%; margin:10px auto" >
		<textarea name="content" class="form-control" rows="10"></textarea>
		 </div>
		 </div>
		
		<input id="btn_write" name="write" type="submit" class="btn btn-primary"  value="글쓰기"/>
	
	
		<input type="reset" class="btn btn-danger"  value="취소"/>
		
		</div>
		</form>
		</div>`
	}
} 