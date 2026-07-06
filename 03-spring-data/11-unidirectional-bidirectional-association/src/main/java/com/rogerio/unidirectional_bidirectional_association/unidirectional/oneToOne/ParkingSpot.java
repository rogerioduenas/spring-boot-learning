package com.rogerio.unidirectional_bidirectional_association.unidirectional.oneToOne;

import jakarta.persistence.*;

@Entity
public class ParkingSpot {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
  @SequenceGenerator(name = "id_gen", sequenceName = "seq_id", allocationSize = 1)
  private Long id;
}
