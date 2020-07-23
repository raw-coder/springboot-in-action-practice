package com.manning.readinglist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadingListController {

  private static final String reader = "steve";

  private ReadingListRepository readingListRepository;

  public ReadingListController(ReadingListRepository readingListRepository) {
    this.readingListRepository = readingListRepository;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String readerBooks(Model model) {
    List<Book> readingBookList = readingListRepository.findByReader(reader);
    if (readingBookList != null) {
      model.addAttribute("books", readingBookList);
    }
    return "readingList";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String addToReadingList(Book book) {
    book.setReader(reader);
    readingListRepository.save(book);
    return "redirect:/";
  }
}
