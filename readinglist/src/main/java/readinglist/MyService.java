package readinglist;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Conditional(JdbcTemplateCondition.class)
@Service
public class MyService {
}
