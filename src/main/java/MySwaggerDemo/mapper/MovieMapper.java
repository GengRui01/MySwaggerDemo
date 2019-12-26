package MySwaggerDemo.mapper;

import MySwaggerDemo.domain.entity.Movie;
import MySwaggerDemo.domain.query.MovieQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MovieMapper {

    List<Movie> getList(MovieQuery query);

    Movie getDetail(String movieNo);

    String getLastMovieNo();

    int checkName(String movieNo, String name);

    int insert(Movie movie);

    int update(Movie movie);
}