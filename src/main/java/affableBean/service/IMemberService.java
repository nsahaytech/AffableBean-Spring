package affableBean.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;

import affableBean.domain.Member;
import affableBean.domain.PasswordResetToken;
import affableBean.domain.VerificationToken;
import affableBean.validation.EmailExistsException;


public interface IMemberService {

    public Page<Member> findAllCustomers(Integer pageNumber);
    
    Member registerNewMemberAccount(MemberDto accountDto) throws EmailExistsException;

    Member getMember(String verificationToken);

    Member saveNewCustomer(Member Member);

    Member saveRegisteredCustomer(Member member);
    
    Member saveAndFlush(Member Member);

    void deleteMember(Member Member);

    void createVerificationTokenForMember(Member Member, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    VerificationToken generateNewVerificationToken(String token);

    void createPasswordResetTokenForMember(Member Member, String token);

    Member getMemberByEmail(String email);

	Member getMemberById(Integer id);

//    Member getMemberByName(String name);

    PasswordResetToken getPasswordResetToken(String token);

    Member getMemberByPasswordResetToken(String token);

    void changeMemberPassword(Member Member, String password);

    boolean checkIfValidOldPassword(Member Member, String password);

	public Member getCustomerFromRequest(HttpServletRequest request);

	public boolean checkEmailExists(String email);

}
