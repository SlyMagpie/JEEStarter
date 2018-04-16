package lt.vu.usecases.mybatis.mymodel;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Lectureroom {

    private Integer id;


    private String title;

    private List<Cable> cables; //gal ne ta library importinai? Mapper
}