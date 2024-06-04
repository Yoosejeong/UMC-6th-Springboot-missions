package umc.spring.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Store;
import umc.spring.study.domain.User;
import umc.spring.study.domain.common.BaseEntity;
import umc.spring.study.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition =  "VARCHAR(15) DEFAULT 'CHALLENGING'")
    private MissionStatus missionStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public void setUser(User user){
        if (this.user != null)
            user.getUserMissionList().remove(this);
        this.user = user;
        user.getUserMissionList().add(this);
    }

    public void setMission(Mission mission){
        if (this.mission != null)
           mission.getUserMissionList().remove(this);
        this.mission = mission;
        mission.getUserMissionList().add(this);
    }

}
