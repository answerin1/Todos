package com.example.todo.service;

import com.example.todo.Dto.MemberResponseDto;
import com.example.todo.Dto.SignUpResponseDto;
import com.example.todo.entity.Member;
import com.example.todo.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.ManyToOne;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sun.font.CCharToGlyphMapper;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public SignUpResponseDto signUp(String username, String password, Integer age) {

        Member member = new Member(username, password, age);

        Member savedMember = memberRepository.save(member);


        return new SignUpResponseDto(savedMember.getId(), savedMember.getUsername(), savedMember.getAge());
    }

    public MemberResponseDto findById(Long id) {
        
        memberRepository.findById(id);
        
        if (memberRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id : " + id);
        }

        Member findMember = optionalMember.get(); //왜 빨간줄...???

        return new MemberResponseDto(findMember.getUsername(), findMember.getAge());
    }

    @Transactional //묶어주는 기능(하나의 트렌젝션 내에서 동작하게 만들어준다)
    public void updatePassword(Long id, String oldPassword, String newPassword) {

        Member findMember = memberRepository.findByIdOrElseThrow(id);

        if (!findMember.getPassword().equals(oldPassword)) {
            throw new ResponseStatusException(HttpStatus .UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }

        findMember.updatedPassword(newPassword);
    }
}
