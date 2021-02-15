package com.ch.ch07.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.ch.ch07.model.Member;
@Controller
public class UploadController {
	@RequestMapping("uploadForm")
	public String uploadForm() {
		return "uploadForm";
	}
	@RequestMapping("uploadForm3")
	public String uploadForm3() {
		return "uploadForm3";
	}
	@RequestMapping("upload")
	public String upload(@RequestParam("file") MultipartFile mf,
			Member member,Model model,HttpSession session) throws IllegalStateException, IOException {
		String fileName = mf.getOriginalFilename();			
		String real=session.getServletContext().getRealPath("/upload");
		FileOutputStream fos = 
			new FileOutputStream(new File(real+"/"+fileName));
		fos.write(mf.getBytes());
		fos.close();
		mf.transferTo(new File("c:/java/"+fileName));
		int fileSize = (int)mf.getSize();
		model.addAttribute("fileName", fileName);
		model.addAttribute("fileize", fileSize);
		model.addAttribute("id", member.getId());
		model.addAttribute("name", member.getName());
		return "upload";
	}
	@RequestMapping("upload2")
	public String upload2(Member member,Model model,HttpSession session) throws IllegalStateException, IOException {
		// String fileName = member.getFile().getOriginalFilename();
		String fileName1=member.getFile().getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		String fileName = uuid+"-"+fileName1;
		int fileSize = (int)member.getFile().getSize();
		String real=session.getServletContext().getRealPath("/upload");
		FileOutputStream fos = 
			new FileOutputStream(new File(real+"/"+fileName));
		fos.write(member.getFile().getBytes());
		fos.close();
		model.addAttribute("fileName", fileName);
		model.addAttribute("fileSize", fileSize);
		model.addAttribute("id", member.getId());
		model.addAttribute("name", member.getName());
		return "upload";
	}
	// MultipartHttpServletRequest 여러개 사진을 한번에 입력 받음
	@RequestMapping("upload3")
	public String upload3(HttpSession session,
			MultipartHttpServletRequest mhs, Model model) throws IOException {
		String real = 
			session.getServletContext().getRealPath("/upload");
		List<MultipartFile> list = mhs.getFiles("file");
		String name = mhs.getParameter("name");
		String id = mhs.getParameter("id");
		List<String> fileList = new ArrayList<String>();
		for(MultipartFile mf : list ) {
			String fileName = mf.getOriginalFilename();
			fileList.add(fileName);
			FileOutputStream fos = 
				new FileOutputStream(new File(real+"/"+fileName));
			fos.write(mf.getBytes());
			fos.close();
		}
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("fileList", fileList);
		return "upload3";
	}
}



