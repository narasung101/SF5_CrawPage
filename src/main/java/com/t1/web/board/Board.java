package com.t1.web.board;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Board {
	private String bno, title, content, writer, bdate, bcount; 
	
}
