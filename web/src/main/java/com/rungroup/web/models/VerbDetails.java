// package com.rungroup.web.models;

// import java.time.LocalDateTime;

// import com.rungroup.web.repositories.Implementations.BRepository;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToOne;
// import jakarta.persistence.Table;

// import lombok.Data;
// import lombok.NoArgsConstructor;
// import lombok.experimental.SuperBuilder;

// @Data
// @SuperBuilder
// @Entity
// @Table(name = "Verb_details")
// @NoArgsConstructor
// public class VerbDetails {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
    
//     // @OneToOne(cascade = CascadeType.ALL)
//     // @JoinColumn(name = "b_id", referencedColumnName = "id") 
//     // protected User user;

//     protected Long target_id;


//     @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//     private LocalDateTime created_at;
//     @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//     private LocalDateTime updated_at;

//     public B getTarget(){
//         return new BRepository().findById(target_id);
//     }
// }


