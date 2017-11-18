package com.example.android.redditlikeproject.ViewModel;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.android.redditlikeproject.data.entities.Comment;
import com.example.android.redditlikeproject.data.entities.Post;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;


/**
 * Created by Aptivist-U001 on 11/14/2017.
 */

public class Main {


    public static void main(String[] args) {
//        MutableLiveData<String> userId = new MutableLiveData<>();
//        userId.setValue("omar");
//        LiveData<User> user = Transformations.switchMap(userId, id -> getUser(id) );

//        Observable.range(0, 20)
//                .map(new Function<Integer, Integer>() {
//                    @Override
//                    public Integer apply(Integer integer) throws Exception {
//                        return integer * 2;
//                    }
//                })
//                .flatMap(new Function<Integer, ObservableSource<?>>() {
//
//                    @Override
//                    public ObservableSource<?> apply(Integer integer) throws Exception {
//                        return Observable.just(integer / 2, integer % 2);
//                    }
//                })
//                .subscribe(System.out::println);

        List<Author> authors = new ArrayList<>();
        List<Book> books = new ArrayList<Book>();

        Observable.range(1, 10)
                .map(index -> new Author(index, "Name" + index))
                .toList()
                .subscribe(list -> authors.addAll(list));

        books.add(new Book(1, 1, "Some Book"));
        books.add(new Book(2, 1, "Some Book"));
        books.add(new Book(3, 2, "Some Book"));
        books.add(new Book(4, 2, "Some Book"));
        books.add(new Book(5, 2, "Some Book"));
        books.add(new Book(6, 3, "Some Book"));
        books.add(new Book(6, 4, "Some Book"));


        Observable.just(authors).map(new Function<List<Author>, List<Author>>() {
            @Override
            public List<Author> apply(List<Author> authors) throws Exception {
                for(Author author: authors){
                    author.extra = "extra1";
                }
                return authors;
            }
        }).forEach(authors1 -> Observable.fromArray(authors1.toArray()).forEach(o -> System.out.println(((Author)o).extra)));
    }


    private static class Author {
        public Integer id;
        public String name;
        public Object extra;

        public Author(Integer id, String name) {
            this.name = name    ;
        }
    }

    private static class Book{
        public Integer id;
        public Integer authorId;
        public String name;

        public Book(Integer sbn, Integer authorId, String name) {
            this.id = sbn;
            this.authorId = authorId;
            this.name = name;
        }
    }


}
