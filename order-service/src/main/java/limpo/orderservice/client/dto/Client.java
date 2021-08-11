package limpo.orderservice.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(columnDefinition = "varchar(255) default 'X'")
    private String firstName;

    @Column(columnDefinition = "varchar(255) default 'X'")
    private String lastName;

    private String address;

    @Column(columnDefinition = "varchar(255) default 'X'",unique = true)
    private String phone;

    @Column(columnDefinition = "varchar(255) default 'X'")
    private Long bulstat;

    @Column(columnDefinition = "varchar(255) default 'X'")
    private String vatNumber;

    @Column(columnDefinition = "varchar(255) default 'Individual'")
    private String type;

}