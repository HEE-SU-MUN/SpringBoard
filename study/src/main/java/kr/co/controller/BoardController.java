package kr.co.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.service.BoardService;
import kr.co.vo.BoardVo;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	 BoardService service;

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@RequestMapping(value = "/board/writeView", method = RequestMethod.GET)
	public void writeView()throws Exception{
			logger.info("writeView");
		// TODO Auto-generated constructor stub
		
	}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String write(BoardVo boardVo)throws Exception{
			service.write(boardVo);
			
			logger.info("write");
			
			return "redirect:/board/table";
	}
	@RequestMapping(value = "/table", method = RequestMethod.GET)
	public String list(Model model)throws Exception{
		logger.info("list");
		
		model.addAttribute("list",service.list());
		
		return "board/table";
		
}
	@RequestMapping(value = "/readView", method = RequestMethod.GET)
	public String read(BoardVo boardVo ,Model model)throws Exception{
		logger.info("read");
		
		model.addAttribute("read",service.read(boardVo.getBno()));
		
		return "board/readView";
}
	
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public String updateView(BoardVo boardVo,Model model)throws Exception{
		
			model.addAttribute("update",service.read(boardVo.getBno()));
			
			logger.info("update");
			
			return "board/updateView";
}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVo boardVo)throws Exception{
		
			service.update(boardVo);
			
			logger.info("update");
			
			return "redirect:/board/table";
}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(BoardVo boardVo)throws Exception{
		
			service.delete(boardVo.getBno());
			
			logger.info("delete");
			
			return "redirect:/board/table";
}
}
