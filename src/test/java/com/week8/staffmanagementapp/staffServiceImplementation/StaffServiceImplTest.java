package com.week8.staffmanagementapp.staffServiceImplementation;

import com.week8.staffmanagementapp.Models.Staff;
import com.week8.staffmanagementapp.Repository.StaffRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class StaffServiceImplTest {
    @Mock
    StaffRepository staffRepository;
    @InjectMocks
    StaffServiceImpl staffService;
    Staff staff;

    @BeforeEach
    void setUp() {
        staff = new Staff();
        staff.setStaffId("3456");
        staff.setFirstName("Kosy");
        staff.setLastName("Ojiakor");
        staff.setPassword("2345");
        staff.setGender("female");
        staff.setDob("24-02-1997");
        staff.setEmail("kosy@gmail.com");
        staff.setRole("admin");
        staff.setPhoneNumber("09060106011");

    }

    @Test
    void getAllStaff() {

//        void shouldAddUserTest() {
//            //mock userRepository
//            when(userRepository.save(any(User.class))).thenReturn(user);
//            //call the method to be tested
//            userService.addUser(user);
////            userService.logInUser(user);
//            //Assertions
//            verify(userRepository, times(1)).save(any(User.class));
//        }

    }

    @Test
    void addStaff() {

        when(staffRepository.save(any(Staff.class))).thenReturn(staff);
        staffService.addStaff(staff);
        verify(staffRepository, times(1)).save(any(Staff.class));
//        void shouldAddUserTest() {
//            //mock userRepository
//            when(userRepository.save(any(User.class))).thenReturn(user);
//            //call the method to be tested
//            userService.addUser(user);
////            userService.logInUser(user);
//            //Assertions
//            verify(userRepository, times(1)).save(any(User.class));
//        }
    }

    @Test
    void getStaffById() {
    }

    @Test
    void deleteStaffById() {
    }

    @Test
    void getStaffByEmail() {
    }

    @Test
    void getStaffByEmailAndPassword() {
    }

    @Test
    void getStaffByStaffId() {
    }

    @Test
    void changePassword() {
    }
}
//   here
//@ExtendWith(MockitoExtension.class)
//class UserServiceImplTests {
//    @Mock
//    private UserRepository userRepository;
//    @InjectMocks
//    private UserServiceImplementation userService;
//    private User user;
//
//    @BeforeEach
//    void setUp() {
//        user = new User();
//        user.setFirstName("user");
//        user.setSurName("Decagon");
//        user.setEmailAddress("user@gmail.com");
//        user.setGender("Male");
//        user.setPassword("1234");
//    }
//
//    @Test
//    void shouldAddUserTest() {
//        //mock userRepository
//        when(userRepository.save(any(User.class))).thenReturn(user);
//        //call the method to be tested
//        userService.addUser(user);
////            userService.logInUser(user);
//        //Assertions
//        verify(userRepository, times(1)).save(any(User.class));
//    }
//
//    @Test
//    void shouldLogInUserTest() {
//        //mock userRepository
////
//        when(userRepository.getUserByEmailAddressAndPassword(anyString(), anyString())).thenReturn(Optional.of(user));
//        //then call the method to be tested
//        ResponseDTO foundUser = userService.logInUser(user);
//        //assertions
//        assertNotNull(foundUser);
//        assertEquals("user@gmail.com", foundUser.getData().getEmailAddress());
//        verify(userRepository, times(1)).getUserByEmailAddressAndPassword(anyString(), anyString());
//    }
//}