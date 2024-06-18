package umc.spring.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CollectionIdJdbcTypeCode;
import org.springframework.cglib.core.Local;
import umc.spring.study.domain.common.BaseEntity;
import umc.spring.study.domain.mapping.UserFood;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length =20)
    private String name;

    @Column(nullable = false, length =30)
    private String address;

    private Float star;

    private LocalTime open;

    private LocalTime closed;

    @OneToMany(mappedBy = "store" , cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

    @OneToMany(mappedBy = "store" , cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    public void setRegion(Region region) {
        if (this.region != null)
            region.getStoreList().remove(this);
        this.region = region;
        region.getStoreList().add(this);
    }
}

