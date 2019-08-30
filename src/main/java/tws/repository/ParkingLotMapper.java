package tws.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tws.entity.ParkingLot;

import java.util.List;
@Mapper
public interface ParkingLotMapper {
    @Select("select * from parkingLot")
    List<ParkingLot> selectAll();

    @Insert("insert into parkingLot values(#{parkingLot.parkingLotID},#{parkingLot.availablePositionCount}," +
            "#{parkingLot.capacity},#{parkingLot.parkingBoyID})")
    void insert(@Param("parkingLot") ParkingLot parkingLot);

    @Select("select * from parking_lot where parkingBoyID = #{parkingBoyId}")
    List<ParkingLot> selectByParkingBoyId(@Param("parkingBoyId")int parkingBoyId);

}
