package com.example.controller;


import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.dto.BoardVO;
import com.example.dto.PagingVO;
import com.example.dto.UserVO;
import com.example.service.BoardService;
import com.example.service.UserService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private BoardService Boardservice;
	@Inject
	private UserService userService;

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	/** 로그인 화면 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginform(Locale locale, Model model) throws Exception{
		
		logger.info("loginform");
		return "loginform";
	}
	
	/** 로그인 처리 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserVO vo, HttpSession session, HttpServletResponse response, Model model) throws Exception{
		
		logger.info("login");
		
		response.setContentType("text/html; charset=UTF-8");
		//PrintWriter out = response.getWriter();
		boolean result = userService.login(vo, session);
		if(result == true)
		{
			return "login";
		}
		else
		{
			//out.println("<script>alert('아이디나 비밀번호를 확인해주세요')</script>");

			//logger.info("flush");
			//out.flush();
			return "loginfail";
		}
		
	}
	
	
	/** 로그인 실패 */
	@RequestMapping(value = "/loginfail", method = RequestMethod.GET)
	public String loginfail(Locale locale, Model model) throws Exception{
		
		logger.info("loginfail");
		return "loginfail";
	}
	
	
	
	/** 로그아웃*/
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, UserVO vo, HttpSession session) throws Exception{
		
		logger.info("logout");
		session.invalidate();
		return "logout";
	}
	
	
	/** 회원가입 페이지 */
	@RequestMapping(value = "/joinform", method = RequestMethod.GET)
	public String joinform(Locale locale, Model model) throws Exception{
		
		logger.info("joinform");
		return "joinform";
	}
	
	/** 회원가입 */
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Locale locale, Model model, UserVO vo) throws Exception{
		
		logger.info("join");
		userService.register(vo);
		model.addAttribute("userInfo", userService.userInfo(vo));
		return "join";
	}
	
	/**마이 페이지 */
	@RequestMapping(value = "/mypage", method =  {RequestMethod.GET, RequestMethod.POST})
	public String mypage(Model model, HttpSession session, UserVO vo)throws Exception{

		logger.info("mypage");
		model.addAttribute("userInfo_session", userService.userInfo_session(session.getAttribute("id").toString()));
		return "mypage";
	}
	
	
	
	/** 회원정보 수정*/
	@RequestMapping(value = "/user_modify", method = RequestMethod.POST)
	public String user_modify(Model model, UserVO vo, HttpSession session) throws Exception{
		
		logger.info("user_modify");
		userService.user_modify(vo);
		session.invalidate();
		return "user_modify";
	}
	
	
	/** 회원탈퇴 페이지*/
	@RequestMapping(value = "/user_deleteform", method =  {RequestMethod.GET, RequestMethod.POST})
	public String user_deleteform(Model model, UserVO vo, HttpSession session) throws Exception{
		
		logger.info("user_deleteform");
		return "user_deleteform";
	}
	
	
	/** 회원탈퇴*/
	@RequestMapping(value = "/user_delete", method = RequestMethod.POST)
	public String user_delete(Model model, UserVO vo, HttpSession session, HttpServletRequest req, HttpServletResponse response) throws Exception{
		
		logger.info("user_delete");
		Map<String, String> info = new HashMap<String, String>();
		info.put("id", session.getAttribute("id").toString());
		info.put("password", req.getParameter("password"));
		userService.user_delete(info);
		//return "user_delete";
		
		
		
		
		response.setContentType("text/html; charset=UTF-8");
		logger.info("user_delete");
		Map<String, String> information = new HashMap<String, String>();
		information.put("id", session.getAttribute("id").toString());
		information.put("password", req.getParameter("password"));
		
		boolean result = userService.user_delete(information);
		
		if(result == true)
		{
			return "user_delete";
		}
		else
		{
			return "user_deletefail";
		}
	}

	
	
	
	/** 글 목록 */
	/*
	 * @RequestMapping(value = "/home", method = RequestMethod.GET) public String home( Model model) throws Exception{
	 * logger.info("home" + "----- " + Boardservice); 
	 * List<BoardVO> memberList = Boardservice.selectMember(); model.addAttribute("memberList", memberList);
	 * return "home"; }
	 */
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home( PagingVO vo, Model model
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage) throws Exception{

		logger.info("home");
		int total = Boardservice.countBoard();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "5";
		}
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		logger.info("please" + vo);
		model.addAttribute("paging", vo);
		model.addAttribute("viewAll", Boardservice.selectBoard(vo));
		return "home";
	}
	
	/** 글 상세 페이지 */
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(BoardVO vo, Model model)throws Exception{

		logger.info("view");
		int idx =  vo.getIdx();
		model.addAttribute("view", Boardservice.view(idx));
		Boardservice.count(idx);
		return "view";
	}
	
	/** 글 삭제 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Locale locale,BoardVO vo, Model model)throws Exception{

		logger.info("delete");
		int idx =  vo.getIdx();
		Boardservice.delete(idx);
		return "delete";
	}
	
	/** 글 수정 페이지 */
	@RequestMapping(value = "/modifyform", method = RequestMethod.GET)
	public String modifyform(Locale locale,BoardVO vo, Model model)throws Exception{

		logger.info("modifyform");
		int idx =  vo.getIdx();
		model.addAttribute("modifyform", Boardservice.view(idx));
		return "modifyform";
	}
	
	/** 글 수정 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(Locale locale,BoardVO vo, Model model)throws Exception{

		logger.info("modify");
		Boardservice.modify(vo);
		return "modify";
	}
	
	/** 글 작성 페이지 */
	@RequestMapping(value = "/writeform", method = RequestMethod.GET)
	public String writeform(Locale locale,UserVO vo, HttpSession session, HttpServletResponse response)throws Exception{

		logger.info("writeform");
		return "writeform";
	}
	
	
	/** 글 작성 */
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Locale locale, BoardVO vo)throws Exception{
		
		logger.info("write");
		logger.info("write------" + vo.getWriter());
		Boardservice.write(vo);
		return "write";
	}
	

	
	
	
}
