package edu.voloshin.tryshop.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class Passport {
   @Id
   private String id;
   private String number;
   private String firstName;
   private  String middleName;
   private String lastName;
   private LocalDate birthDate;
   private LocalDate dataObt;

   public Passport() {
   }

   public Passport(String number, String firstName, String middleName, String lastName, LocalDate birthDate, LocalDate dataObt) {
      this.number = number;
      this.firstName = firstName;
      this.middleName = middleName;
      this.lastName = lastName;
      this.birthDate = birthDate;
      this.dataObt = dataObt;
   }

   public Passport(String id, String number, String firstName, String middleName, String lastName, LocalDate birthDate, LocalDate dataObt) {
      this.id = id;
      this.number = number;
      this.firstName = firstName;
      this.middleName = middleName;
      this.lastName = lastName;
      this.birthDate = birthDate;
      this.dataObt = dataObt;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getNumber() {
      return number;
   }

   public void setNumber(String number) {
      this.number = number;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getMiddleName() {
      return middleName;
   }

   public void setMiddleName(String middleName) {
      this.middleName = middleName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public LocalDate getDataObt() {
      return dataObt;
   }

   public void setDataObt(LocalDate dataObt) {
      this.dataObt = dataObt;
   }

   public LocalDate getBirthDate() {
      return birthDate;
   }

   public void setBirthDate(LocalDate birthDate) {
      this.birthDate = birthDate;
   }

   @Override
   public String toString() {
      return "Passport{" +
              "id='" + id + '\'' +
              ", number='" + number + '\'' +
              ", firstName='" + firstName + '\'' +
              ", middleName='" + middleName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", birthDate=" + birthDate +
              ", dataObt=" + dataObt +
              '}';
   }
}
