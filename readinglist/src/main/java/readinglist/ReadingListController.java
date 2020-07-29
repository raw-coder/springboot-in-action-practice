package readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadingListController {

  private final ReadingListRepository readingListRepository;

  @Autowired
  public ReadingListController(ReadingListRepository readingListRepository) {
    this.readingListRepository = readingListRepository;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String readerBooks(Reader reader, Model model) {
    List<Book> readingBookList = readingListRepository.findByReader(reader);
    if (readingBookList != null) {
      model.addAttribute("books", readingBookList);
      model.addAttribute("reader", reader);
    }
    return "readingList";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String addToReadingList(Reader reader, Book book) {
    book.setReader(reader);
    readingListRepository.save(book);
    return "redirect:/";
  }
}
