package com.twelvebooks.twelvebook.controller.api;

import com.twelvebooks.twelvebook.domain.Book;
import com.twelvebooks.twelvebook.domain.Challenge;
import com.twelvebooks.twelvebook.domain.User;
import com.twelvebooks.twelvebook.dto.ChallengeDto;
import com.twelvebooks.twelvebook.dto.ChallengeResultDto;
import com.twelvebooks.twelvebook.service.BookService;
import com.twelvebooks.twelvebook.service.ChallengeService;
import com.twelvebooks.twelvebook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.xml.bind.helpers.PrintConversionEventImpl;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/challenges")
@RequiredArgsConstructor
public class ChallengeAPIController {

    @Autowired
    ChallengeService challengeService;

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;



    @GetMapping
    public List<Challenge> getChallenge(@RequestParam(name = "userId") Long id){

        List<Challenge> list = challengeService.getChallengesByUserId(id);

        return list;

    }


    @PostMapping
    public ResponseEntity<ChallengeResultDto> addChallenge(@RequestBody ChallengeDto challengeDto, Principal principal){
            ChallengeResultDto challengeResultDto = new ChallengeResultDto();

            //Challenge에 user를 저장
            String email = principal.getName();
            User user = userService.getUserByEmail(email);
            Challenge challenge = new Challenge();
            challenge.setUser(user);

            //isbn을 통해 책 가져오기
            Book book = bookService.getBookByIsbn(challengeDto.getIsbn());

            if(book == null){
                Book resultBook = getBook(challengeDto);
                challenge.setBook(resultBook);
                challenge.setBooksTitle(resultBook.getTitle());
                challenge.setThumbnailImage(resultBook.getThumbnailImage());
                challenge.setIsbn(resultBook.getIsbn());
            }else{
                challenge.setBook(book);
                challenge.setBooksTitle(book.getTitle());
                challenge.setThumbnailImage(book.getThumbnailImage());
                challenge.setIsbn(book.getIsbn());
            }

                challenge.setStartDate(challengeDto.getStartDate());
                challenge.setEndDate(challengeDto.getEndDate());
                challenge.setVisibility(challengeDto.getVisibility());
                challenge.setDays(challengeDto.getDays());

                Challenge result = challengeService.addChallenge(challenge);

                if(result != null){
                    challengeResultDto.setResultMessage("도전이 등록되었습니다.");
                }else{
                    challengeResultDto.setResultMessage("등록 실패!");
                }
            return new ResponseEntity<>(challengeResultDto, HttpStatus.OK);
    }

    private Book getBook(@RequestBody ChallengeDto challengeDto) {
        Book book1 = new Book();
        book1.setAuthor(challengeDto.getAuthor());
        book1.setThumbnailImage(challengeDto.getThumbnailImage());
        book1.setPublisher(challengeDto.getPublisher());
        book1.setTitle(challengeDto.getBooksTitle());
        book1.setTranslator(challengeDto.getTranslator());
        book1.setIsbn(challengeDto.getIsbn());
        return bookService.addBook(book1);
    }
}
