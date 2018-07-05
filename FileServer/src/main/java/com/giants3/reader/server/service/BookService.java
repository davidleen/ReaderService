package com.giants3.reader.server.service;

import com.giants3.reader.entity.Book;
import com.giants3.reader.entity.ComicBook;
import com.giants3.reader.entity.ComicChapter;
import com.giants3.reader.noEntity.ComicChapterInfo;
import com.giants3.reader.noEntity.RemoteData;
import com.giants3.reader.server.repository.BookRepository;
import com.giants3.reader.server.repository.ComicBookRepository;
import com.giants3.reader.server.repository.ComicChapterRepository;
import com.giants3.reader.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidleen29 on 2018/5/12.
 */
@Service
public class BookService  extends AbstractService{


    @Autowired
    BookRepository bookRepository;
    @Autowired
    ComicBookRepository comicBookRepository;
    @Autowired
    ComicChapterRepository comicChapterRepository;
    public RemoteData<Book> list()
    {


        return wrapData(bookRepository.findByNameLike(StringUtils.sqlLike("")));
    }

    public void addOne() {


        Book book=new Book();
        book.name="a new book";
        bookRepository.save(book);

    }

    public void addOneComic() {


        ComicBook book=new ComicBook();
        book.name="a new  comic book";
        book.comicFilePath="aa1111111111";
        bookRepository.save(book);

    }

    public RemoteData<ComicBook> listComic() {

        return wrapData(comicBookRepository.findByNameLike(StringUtils.sqlLike("")));

    }

    public RemoteData<ComicChapterInfo> findComicChapters(long bookId) {

        final ComicBook comicBook = comicBookRepository.findOne(bookId);
        final List<ComicChapter> chapters = comicChapterRepository.findByBookIdEquals(bookId);
        List<ComicChapterInfo> comicChapterInfos=new ArrayList<>();
        for(ComicChapter chapter:chapters)
        {
            ComicChapterInfo comicChapterInfo=new ComicChapterInfo();
            comicChapterInfo.comicChapter=chapter;
            comicChapterInfo.comicFileList=null;
            comicChapterInfos.add(comicChapterInfo);

        }
        return wrapData(comicChapterInfos);

    }
}
