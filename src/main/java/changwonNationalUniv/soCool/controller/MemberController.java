package changwonNationalUniv.soCool.controller;

import changwonNationalUniv.soCool.dto.MemberRequest;
import changwonNationalUniv.soCool.dto.MemberResponse;
import changwonNationalUniv.soCool.entity.Gender;
import changwonNationalUniv.soCool.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @RequestMapping("/member/list")
    @ResponseBody
    public ResponseEntity<List<MemberResponse>> list() {

        List<MemberResponse> members = memberService.findAll();

        return ResponseEntity.ok(members);
    }

    @GetMapping("/join")
    public String joinForm(Model model) {
        model.addAttribute("member", new MemberRequest());
        return "/member/join";
    }

    @PostMapping("/join")
    public String join(@Validated @ModelAttribute("member") MemberRequest form, BindingResult bindingResult, Model model) {


        if(bindingResult.hasErrors()) {
            return "/member/join";
        }

        memberService.save(form);

        return "redirect:/";
    }

    @ModelAttribute("genderTypes")
    public Gender[] itemTypes() {
        return Gender.values();
    }
}
