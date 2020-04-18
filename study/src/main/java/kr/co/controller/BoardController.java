package kr.co.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.service.BoardService;
import kr.co.vo.BoardVo;
import kr.co.vo.Criteria;
import kr.co.vo.PageDTO;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	 BoardService service;

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@GetMapping(value = "/register")
	public void register()throws Exception{
			logger.info("writeView");
		// TODO Auto-generated constructor stub
		
	}
	
	@PostMapping(value = "/register")
	public String write(BoardVo boardVo,RedirectAttributes rttr)throws Exception{
			service.register(boardVo);
			
			rttr.addFlashAttribute("result", boardVo.getTitle());
			logger.info("write");
			
			return "redirect:/board/list";
	}
	/*
	 * @RequestMapping(value = "/list", method = RequestMethod.GET) public String
	 * list(Model model)throws Exception{ logger.info("list");
	 * 
	 * model.addAttribute("list",service.getList());
	 * 
	 * return "board/list";
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET) public void
	  list(Criteria cri ,Model model)throws Exception{ 
		logger.info("list:"+ cri);
	 // model.addAttribute("pageMaker",new PageDTO(cri,10000));
	  model.addAttribute("list",service.getList(cri));
	  
	  int total = service.getTotal(cri);
	  model.addAttribute("pageMaker", new PageDTO(cri,total));
	  
	 
}
	@GetMapping({"/get","/modify"})
	public void get(BoardVo boardVo ,@ModelAttribute("cri") Criteria cri,Model model)throws Exception{
		logger.info("get");
		
		model.addAttribute("board",service.get(boardVo.getBno()));
		
		
}
	
	/*
	 * @RequestMapping(value = "/updateView", method = RequestMethod.GET) public
	 * String updateView(BoardVo boardVo,Model model)throws Exception{
	 * 
	 * model.addAttribute("JUN",service.get(boardVo.getBno()));
	 * 
	 * logger.info("update");
	 * 
	 * return "board/updateView";
	 */
//}
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String update(BoardVo boardVo, Criteria cri,RedirectAttributes rttr)throws Exception{
			logger.info("update");
			
			if(service.modify(boardVo)) {
				rttr.addFlashAttribute("result",boardVo.getTitle());
			}
			rttr.addAttribute("pageNum",cri.getPageNum());
			rttr.addAttribute("amount",cri.getAmount());
			rttr.addAttribute("type",cri.getType());
			rttr.addAttribute("keyword",cri.getKeyword());
			return "redirect:/board/list";
					
}
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String delete(BoardVo boardVo,Criteria cri,RedirectAttributes rttr)throws Exception{
			logger.info("delete");
			
			if(service.remove(boardVo.getBno())){
				rttr.addFlashAttribute("result",boardVo.getTitle());
			}
			rttr.addAttribute("pageNum",cri.getPageNum());
			rttr.addAttribute("amount",cri.getAmount());
			rttr.addAttribute("type",cri.getType());
			rttr.addAttribute("keyword",cri.getKeyword());
			
			
			
			return "redirect:/board/list";
}
}
