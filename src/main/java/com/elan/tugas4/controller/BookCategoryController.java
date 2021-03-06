package com.elan.tugas4.controller;

import com.elan.tugas4.model.Address;
import com.elan.tugas4.model.Book;
import com.elan.tugas4.model.BookCategory;
import com.elan.tugas4.repository.BookCategoryRepository;
import com.elan.tugas4.repository.BookRepository;
import com.elan.tugas4.service.BookCategoryService;
import com.elan.tugas4.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/bookcategory/")
public class BookCategoryController {
    @Autowired
    BookCategoryService service;

    @Autowired
    BookCategoryRepository repo;

    //    @JsonIgnore
    @GetMapping("")
    List<BookCategory> getBookCategory(){
        return (List<BookCategory>) repo.findAll();
    }

    @PostMapping("insert")
//    Map insertBookCategory(@RequestBody BookCategory body){
//        Map<String,Object> result = new HashMap<>();
//        System.out.println("body " + body.toString());
//        boolean status = service.addBookCategory(body);
//        if (status){
//            result.put("succes",true);
//            result.put("message","berhasil");
//        }else{
//            result.put("success",false);
//            result.put("message","gagal");
//        }
//
//        return result;
//    }

   public BookCategory insertBookCategory (@RequestBody BookCategory body) {
        BookCategory result = repo.save(body);
        return result;
    }

    @DeleteMapping("delete")
    Map<String, Object> deleteBookCategory(@RequestParam int id) {
        Map<String, Object> result = new HashMap<>();
        if (service.deleteBookCategory(id)) {
            result.put("Success", true);
        } else {
            result.put("Gagal", false);
        }
        return result;
    }

    @PutMapping("update")
    Map<String, Object> updateBookCategory(@RequestBody BookCategory body) {
        System.out.println("body : " + body.toString());
        Map<String, Object> result = new HashMap<>();
        if (service.updateBookCategory(body)) {
            result.put("succes", true);
            result.put("message", "berhasil");
        } else {
            result.put("succes", false);
            result.put("message", "gagal");
        }
        return result;
    }

//    @GetMapping("byTitle")
//    Book findByTitle(@RequestParam String title) {
//        return service.findByTitle(title);
//
//    }
//
//    @GetMapping("byCategory")
//    BookCategory findByCategory(@RequestParam int id) {
//        return service.findByCategory(id);
//
//    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @GetMapping("page")
    public ResponseEntity<Map<String, Object>> getAllUsers(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        try {
            List<BookCategory> book = new ArrayList<BookCategory>();
            Pageable paging = PageRequest.of(page, size);

            Page<BookCategory> pagebook;
            if (search == null) {
                pagebook = repo.findAll(paging);
            } else {
                pagebook = repo.findByNameContaining(search, paging);
            }

            book = pagebook.getContent();

            if (book.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            } else {

                Map<String, Object> result = new HashMap<>();
                result.put("user", book);
                result.put("currentPage", pagebook.getNumber());
                result.put("totalItems", pagebook.getTotalElements());
                result.put("totalPages", pagebook.getTotalPages());


                return new ResponseEntity<>(result, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
