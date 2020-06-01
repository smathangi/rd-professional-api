package uk.gov.hmcts.reform.professionalapi.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import uk.gov.hmcts.reform.professionalapi.domain.PrdEnum;
import uk.gov.hmcts.reform.professionalapi.helper.BaseRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PrdEnumRepositoryTest extends BaseRepository {

    @Test
    public void test_findAll() {
        List<PrdEnum> prdEnums = prdEnumRepository.findAll();

        assertThat(prdEnums).hasSize(39);
        assertThat(prdEnums.get(0).getPrdEnumId().getEnumCode()).isEqualTo(0);
    }

    @Test
    public void test_findByEnabledYes() {
        List<PrdEnum> prdEnums = prdEnumRepository.findByEnabled("YES");

        assertThat(prdEnums).hasSize(31);
        assertThat(prdEnums.get(0).getPrdEnumId().getEnumCode()).isEqualTo(0);
    }

    @Test
    public void test_findByEnabledNo() {
        List<PrdEnum> prdEnums = prdEnumRepository.findByEnabled("NO");

        assertThat(prdEnums).hasSize(8);
        assertThat(prdEnums.get(0).getPrdEnumId().getEnumCode()).isEqualTo(31);
    }

    @Test
    public void test_findAll_containsCaaRoles() {
        List<PrdEnum> prdEnums = prdEnumRepository.findAll();

        assertThat(prdEnums.get(37).getEnumName()).isEqualTo("pui-caa");
        assertThat(prdEnums.get(38).getEnumName()).isEqualTo("caseworker-caa");
    }
}
