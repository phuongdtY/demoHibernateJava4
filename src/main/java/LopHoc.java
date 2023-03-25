import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table (name = "lop_hoc")
public class LopHoc {

    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "ma_lop")
    private String maLop;

    @Column (name = "ten_lop")
    private String tenLop;

    @Column (name = "so_luong_sv")
    private Integer soLuongSv;

    @Column (name = "toa")
    private String toa;

    @Override
    public String toString() {
        return "LopHoc{" +
                "id=" + id +
                ", maLop='" + maLop + '\'' +
                ", tenLop='" + tenLop + '\'' +
                ", soLuongSv=" + soLuongSv +
                ", toa='" + toa + '\'' +
                '}';
    }
//    mới thêm dòng này vô đây nha
}
