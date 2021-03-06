package lt.vu.usecases.mybatis.mydao;

import java.util.List;
import lt.vu.usecases.mybatis.mymodel.Cableconnection;
import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;

@Mapper
public interface CableconnectionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CABLECONNECTION
     *
     * @mbg.generated Tue Apr 17 01:41:30 EEST 2018
     */
    int deleteByPrimaryKey(@Param("roomid") Integer roomid, @Param("cableid") Integer cableid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CABLECONNECTION
     *
     * @mbg.generated Tue Apr 17 01:41:30 EEST 2018
     */
    int insert(Cableconnection record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CABLECONNECTION
     *
     * @mbg.generated Tue Apr 17 01:41:30 EEST 2018
     */
    List<Cableconnection> selectAll();
}