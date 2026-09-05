BidPilot — AI RFP / Proposal Operating System

RFP·제안요청서 분석부터 요구사항 추적, 제안 전략 수립, 제안서 작성, 검토, 제출 준비까지 지원하는 B2B AI 제안 운영 서비스
⸻
0. 문서 목적

이 문서는 BidPilot의 제품 기획, MVP 범위, 핵심 도메인, AI 사용 방식, 데이터 모델, 기술 아키텍처, 검증 하네스, 화면 구성, 로드맵을 하나의 기준 문서로 정리한다.

BidPilot은 단순한 “제안서 생성 AI”가 아니다.

핵심은 다음 세 가지다.

1. RFP 요구사항을 빠짐없이 구조화한다.
2. 회사 내부의 실제 근거 자료만 사용해 제안 내용을 만든다.
3. 요구사항 → 답변 → 근거 → 검토 → 제출 상태를 추적한다.

즉, Word 문서를 대신 써주는 제품이 아니라 제안 업무의 운영 체계를 만든다.
⸻
1. 한 줄 정의

RFP를 분석해 요구사항과 평가 기준을 구조화하고, 회사의 실적·인력·기술·레퍼런스를 근거로 제안 전략과 문서를 만들며 제출 전 누락과 위험까지 점검하는 AI 제안 운영 서비스.

짧은 표현:

RFP를 읽고 제안서를 써주는 AI가 아니라, 수주 제안 업무 전체를 관리하는 AI Proposal OS.
⸻
2. 문제 정의

기업의 제안 업무는 반복적이지만 자동화하기 어렵다.

일반적인 업무 흐름은 다음과 같다.

RFP 수신
↓
파일 열람
↓
제안요청사항 수동 정리
↓
평가 기준 확인
↓
부서별 담당자 배정
↓
과거 제안서 검색
↓
실적·인력·기술 자료 수집
↓
목차 작성
↓
초안 작성
↓
수정 반복
↓
누락 검토
↓
가격/증빙/첨부 확인
↓
제출


2.1 RFP 분석이 사람에게 의존한다

RFP가 수십~수백 페이지이고 핵심 요구사항이 여러 장에 흩어져 있다.

- 기능 요구사항
- 기술 요구사항
- 인력 조건
- 사업 수행 조건
- 보안 조건
- 평가 기준
- 제출 형식
- 필수 증빙
- 일정
- 가격 조건

한 번 놓친 요구사항은 감점이나 실격으로 이어질 수 있다.

2.2 기존 제안 자료를 찾는 시간이 오래 걸린다

회사 내부에는 이미 많은 자료가 있지만 Drive, NAS, Notion, SharePoint, Git, 개인 PC 등에 흩어져 있다.

과거 제안서
사업 수행 계획
회사 소개서
레퍼런스
실적 증명
인력 CV
기술 백서
보안 정책
인증서
아키텍처 문서
고객 성공 사례


사람은 매번 비슷한 자료를 다시 찾고 문장을 다시 작성한다.

2.3 제안서 문장은 많지만 “근거”가 약하다

생성형 AI를 그대로 붙이면 다음 문제가 생긴다.

"당사는 대규모 공공 프로젝트 수행 경험이 풍부합니다."
"유사 사업을 다수 성공적으로 수행했습니다."
"99.99% 수준의 안정성을 제공합니다."


실제 자료에 없는 수치·실적·인증이 들어가면 제안서는 위험해진다.

BidPilot은 모든 주요 제안 주장에 대해 다음 질문에 답할 수 있어야 한다.

이 문장은 회사의 어떤 실제 자료에서 나온 것인가?

2.4 요구사항과 제안서 내용의 대응 관계가 보이지 않는다

- RFP 요구사항은 있는데 제안서 답변이 없음
- 답변은 있는데 근거 자료가 없음
- 평가 항목에 중요한 내용이 문서 뒤쪽에 있음
- 같은 요구사항이 여러 장에서 중복/불일치
- 수정 과정에서 필수 문구가 삭제됨

따라서 BidPilot은 Compliance Matrix를 핵심 객체로 가진다.

2.5 리뷰가 문장 교정에 치우친다

실제 중요한 검토는 다음이다.

필수 요구사항이 빠졌는가?
평가 기준을 직접 공략했는가?
근거 없는 수치가 있는가?
증빙 자료가 준비됐는가?
회사 실적과 문장이 일치하는가?
제출 형식을 어겼는가?


BidPilot은 이 검토를 구조화한다.
⸻
3. 핵심 사용자

3.1 1차 타깃

SI / IT 서비스 기업 제안팀

대표적인 상황:

- 공공/민간 IT 구축 사업 RFP
- 시스템 통합
- 클라우드 전환
- 유지보수
- 데이터/AI 구축
- 컨설팅
- 플랫폼 구축

3.2 사용자 역할

Proposal Manager / 제안 PM
- 전체 제안 일정 관리
- RFP 요구사항 정리
- 작성 담당자 배정
- 리뷰 진행
- 최종 제출 책임

Pre-Sales / Solution Architect
- 기술 제안
- 아키텍처
- 솔루션 구성
- 기술 차별화

Sales / Account Manager
- 고객 맥락
- 경쟁 상황
- 수주 전략
- 가격 전략

Delivery / Project Manager
- 수행 계획
- 일정
- 인력
- 위험 관리

Writer / Designer
- 문서 작성
- 구조 정리
- 표현 개선
- PPT/Word 제작

Executive Reviewer
- 최종 수주 관점 검토
- 차별화 메시지
- 리스크 확인
  ⸻
4. 제품 비전

회사가 제안할 때마다 처음부터 다시 시작하지 않게 만드는 것.

한 번 입력한 정보와 수주 경험이 다음 제안에 계속 재사용된다.

회사 자산
+
과거 제안
+
수주/실패 결과
+
새 RFP
↓
BidPilot
↓
이번 제안에 필요한 전략과 문서

⸻
5. 제품 핵심 가치

5.1 빠른 RFP 분석

RFP 업로드 후 다음을 구조화한다.

사업 개요
발주기관
사업 목적
사업 범위
기능 요구사항
비기능 요구사항
기술 요구사항
인력 요건
보안 요구사항
일정
제출 형식
평가 항목
배점
필수 증빙
위험 조건
질의 필요 항목


5.2 Compliance Matrix 자동 생성
RFP ID	요구사항	유형	중요도	배점	담당	대응 섹션	근거	상태
REQ-001	Java 기반 API 서버 구축	기술	필수	5	김OO	4.2	EVD-021	완료
REQ-002	최근 3년 유사사업 실적	실적	필수	10	박OO	2.3	EVD-108	검토
REQ-003	장애복구 계획	운영	평가	5	이OO	5.4	EVD-044	작성중

이 테이블이 제안 프로젝트의 중심이 된다.

5.3 회사 근거 자산화

회사 내부의 반복 사용 가능한 정보를 Proposal Evidence로 구조화한다.

id: EVD-00128
type: PROJECT_REFERENCE
title: 공공기관 실시간 모니터링 시스템 구축
client: 공공기관 A
period: 2026-01 ~ 2026-08
summary: 실시간 모니터링 및 결과분석 시스템 구축
capabilities:
- Java/Spring 기반 백엔드
- PostgreSQL 데이터 처리
- Redis/SSE 실시간 처리
  metrics:
- name: API 조회 시간
  before: 601ms
  after: 44.82ms
  source:
  documentId: DOC-1021
  page: 14
  excerpt: "..."


5.4 근거 기반 제안서 생성

"당사는 실시간 모니터링 시스템 구축 경험을 보유하고 있습니다."
↓
EVD-00128


근거가 없으면 근거 부족으로 반환한다.

5.5 평가 기준 중심 제안 전략

예:

평가항목: 수행 경험 15점

현재 확보 자료
- 유사 구축 실적 3건
- 관련 인력 4명
- 고객 만족도 자료 없음

전략
- 유사 실적을 앞쪽에서 강조
- 프로젝트별 역할/규모/성과를 동일한 포맷으로 정리
- 단순 회사 소개가 아니라 이번 사업 요구사항과 직접 매핑

⸻
6. 제품 포지셔닝

ChatGPT
강점: 문장 생성, 분석, 요약

부족한 점:
- 회사 정본 데이터 관리
- RFP 요구사항 추적
- Compliance Matrix
- 증빙 관리
- 제안 상태 관리
- 제출 체크리스트

Notion / Confluence
강점: 정보 관리, 협업

부족한 점:
- RFP 자동 분석
- 요구사항 추출
- Evidence Mapping
- 제안 전략 자동화
- 근거 검증

Word / PowerPoint
강점: 최종 산출물 편집

부족한 점:
- 요구사항 추적
- 지식 재사용
- AI 검증
- 협업 상태 관리

BidPilot

RFP
+
Company Evidence
+
Past Proposal Knowledge
+
Proposal Workflow
+
AI
=
BidPilot

⸻
7. 핵심 제품 객체

Organization
│
├── Proposal Evidence
├── People
├── Project References
└── Templates

RFP
│
├── Requirements
├── Evaluation Criteria
└── Submission Rules

Bid Project
│
├── Compliance Matrix
├── Strategy
├── Sections
├── Claims
├── Evidence References
├── Reviews
├── Risks
└── Submission Checklist

⸻
8. 전체 사용자 흐름

새 제안 프로젝트 생성
↓
RFP 업로드
↓
RFP Parse
↓
요구사항 / 평가 기준 확인
↓
Compliance Matrix 생성
↓
회사 Evidence 자동 매칭
↓
Bid / No-Bid 판단
↓
제안 전략 수립
↓
목차 / 작성 계획 생성
↓
섹션별 초안 작성
↓
담당자 수정
↓
AI Reviewer
↓
누락 / 근거 / 수치 / 조건 검증
↓
Executive Review
↓
Submission Checklist
↓
제출
↓
Win / Loss 결과 기록
↓
다음 제안 전략 업데이트

⸻
9. 주요 기능

9.1 RFP Workspace

- 사업명
- 발주처
- 공고일
- 제출 마감일
- 예상 사업 규모
- 제안 담당자
- 현재 단계
- 완료율
- 위험 항목
- 미해결 요구사항
- 다음 작업

9.2 RFP Import

MVP:
- PDF 업로드
- DOCX 업로드
- 텍스트 붙여넣기

후속:
- 나라장터 URL
- 이메일 첨부
- Google Drive
- SharePoint
- Notion
- NAS

9.3 RFP Parser

{
"title": "OO 시스템 구축 사업",
"issuer": "OO기관",
"deadline": "2026-10-21T17:00:00+09:00",
"requirements": [],
"evaluationCriteria": [],
"submissionRules": [],
"requiredAttachments": [],
"unmappedFragments": []
}


unmappedFragments를 반드시 둔다. AI가 구조화하지 못한 문장을 버리면 안 된다.

9.4 Requirement Classification

FUNCTIONAL
NON_FUNCTIONAL
TECHNICAL
SECURITY
INFRASTRUCTURE
INTEGRATION
DATA
AI
PERFORMANCE
OPERATIONS
MAINTENANCE
PERSONNEL
PROJECT_MANAGEMENT
REFERENCE
CERTIFICATION
LEGAL
COMMERCIAL
SUBMISSION
OTHER


9.5 Requirement Criticality

MANDATORY
SCORING
OPTIONAL
INFORMATIONAL
UNKNOWN


9.6 Evaluation Criteria Analyzer

evaluation:
- id: EV-001
  category: 기술 이해도
  score: 10
  description: 사업 이해 및 추진 전략
- id: EV-002
  category: 수행 능력
  score: 15
  description: 유사 사업 수행 경험


9.7 Compliance Matrix

상태:

NOT_STARTED
ASSIGNED
DRAFTING
EVIDENCE_MISSING
REVIEW_REQUIRED
COMPLETE
BLOCKED


각 Requirement는 반드시 다음 정보를 가진다.

요구사항 원문
분류
필수 여부
평가 점수
답변 전략
담당자
제안서 위치
Evidence
상태
검토 코멘트


9.8 Proposal Evidence Bank

COMPANY_PROFILE
PROJECT_REFERENCE
TECHNICAL_CAPABILITY
PERSONNEL
CERTIFICATION
SECURITY_POLICY
PROCESS
ARCHITECTURE
CUSTOMER_RESULT
PERFORMANCE_METRIC
PARTNERSHIP
PRODUCT
CASE_STUDY
OTHER


9.9 Evidence Source Traceability

ProposalClaim
↓
EvidenceRef
↓
ProposalEvidence
↓
SourceDocument
↓
원문


9.10 Bid / No-Bid Decision

판단 요소:

기술 적합도
필수 자격 충족 여부
유사 실적
필수 인력 확보
사업 규모
마감까지 남은 시간
예상 경쟁 강도
수익성
전략 고객 여부
미충족 필수 요건


MVP에서는 정량 점수보다 의사결정 보조에 집중한다.

추천: CONDITIONAL BID

강점
- 유사 프로젝트 3건
- 핵심 기술 요구사항 다수 대응 가능

리스크
- 필수 자격증 보유 인력 부족
- 제출까지 6일
- 보안 요구사항 2건 Evidence 없음

결정 전 확인
- 외부 인력 투입 가능 여부
- 인증 대체 인정 여부


9.11 Proposal Strategy

출력:

Win Theme
Key Messages
Differentiators
Risk Positioning
Evaluation Attack Plan
Reference Strategy
Executive Summary Strategy


9.12 Section Planner

각 Section:

목적
연결된 Requirements
연결된 Evaluation Criteria
담당자
필요 Evidence
작성 상태
리뷰 상태


9.13 Section Drafting

AI 입력은 다음으로 제한한다.

RFP Requirement
+
Evaluation Criteria
+
Approved Evidence
+
Template
+
Bid Strategy


자유 생성 금지.

9.14 Claim-Level Evidence Reference

{
"text": "당사는 대규모 동시 접속 환경에서 실시간 전송 병목을 검증한 경험이 있습니다.",
"evidenceRefs": ["EVD-00128"]
}


근거가 없으면:

{
"status": "INSUFFICIENT_EVIDENCE",
"requestedEvidence": "대규모 동시 접속 검증 실적"
}


9.15 Proposal Reviewer

Compliance Reviewer
- RFP 누락
- Mandatory 미대응
- 제출 규칙 위반

Evidence Reviewer
- 근거 없는 주장
- Evidence ID 누락
- 수치 변형
- 실적 기간 오류

Technical Reviewer
- 요구사항과 기술안 불일치
- 아키텍처 모순
- 성능/보안 주장 부족

Executive Reviewer
- 핵심 메시지 약함
- 평가 항목 공략 부족
- 차별점 불명확

Style Reviewer
- 장황함
- 중복
- 문체 불일치
- 용어 불일치

9.16 Risk Register

필수 요건 미충족
Evidence 없음
증빙 미확보
담당자 미배정
마감 임박
평가 고배점 항목 미완료
페이지 제한 초과
수치 불일치
서로 다른 섹션에서 상충된 주장


9.17 Submission Checklist

[ ] 제안서 PDF
[ ] 가격제안서
[ ] 사업자등록증
[ ] 법인등기
[ ] 실적증명
[ ] 투입인력 경력증명
[ ] 보안서약서
[ ] 제출 파일명 규칙
[ ] 페이지 제한
[ ] 제출 시간


9.18 Win / Loss Feedback

WON
LOST
NO_DECISION
WITHDRAWN
DISQUALIFIED


저장 정보:

최종 점수
기술 점수
가격 점수
경쟁사
고객 피드백
실패 사유
성공 요인

⸻
10. AI Agent 구성

초기에는 별도 마이크로서비스가 아니라 하나의 애플리케이션 안의 역할 모듈로 시작한다.

10.1 RFP Parse Agent
- RFP 구조화
- 요구사항 추출
- 평가 기준 추출
- 제출 규칙 추출

금지:
- 없는 요구사항 생성
- Required / Optional 임의 변경

10.2 Evidence Retrieval Agent
- 요구사항과 Evidence 후보 검색
- 관련 근거 제시

금지:
- Evidence 생성
- Evidence 내용 수정

10.3 Bid Strategy Agent
- 강점
- 약점
- Risk
- Win Theme

10.4 Proposal Writer Agent
- Evidence 기반 문장 작성
- 목차에 맞는 초안 생성

금지:
- 근거 없는 수치
- 가짜 실적
- 가짜 인증
- 가짜 인력

10.5 Reviewer Agent
- 누락
- 모순
- 근거 부족
- 요구사항 미대응
  ⸻
11. AI 책임 경계

LLM
→ 추출
→ 요약
→ 관련성 판단
→ 문장 생성

System
→ ID
→ 상태
→ 권한
→ 점수 합산
→ 필수 조건 판정
→ Evidence 존재 여부
→ 마감 계산
→ 검증 결과

⸻
12. Hallucination 방지 원칙

1. 회사에 없는 실적을 만들지 않는다.
2. 원문에 없는 수치를 만들지 않는다.
3. 인증·자격·고객명은 반드시 Evidence가 있어야 한다.
4. 생성 주장에는 Evidence Reference가 있어야 한다.
5. Evidence 부족과 역량 부족을 구분한다.
6. RFP 원문을 정본으로 유지한다.
7. AI가 구조화하지 못한 RFP 문장은 버리지 않는다.
   ⸻
13. 핵심 불변식

INV-001 Requirement는 반드시 RFP 원문 위치를 가진다.
INV-002 Mandatory Requirement는 삭제할 수 없다.
INV-003 Generated Claim은 Evidence Reference 없이 APPROVED가 될 수 없다.
INV-004 Proposal Evidence의 수치는 원문 Source에 존재해야 한다.
INV-005 Evidence는 출처 없이 존재할 수 없다.
INV-006 RFP Required/Optional 분류는 사용자 승인 없이 변경할 수 없다.
INV-007 Compliance Matrix의 모든 Mandatory Requirement는 제출 전에 COMPLETE여야 한다.
INV-008 DISQUALIFY_RISK가 하나라도 있으면 Submission Ready가 될 수 없다.
INV-009 AI Draft는 바로 Final 상태가 될 수 없다.
INV-010 Evidence가 없는 회사 실적·인증·인력 주장은 생성하지 않는다.

⸻
14. 제안 상태 모델

CREATED
↓
RFP_ANALYZING
↓
PLANNING
↓
WRITING
↓
REVIEWING
↓
FINALIZING
↓
READY_TO_SUBMIT
↓
SUBMITTED
↓
WON / LOST / WITHDRAWN


15. Requirement 상태 모델

NOT_STARTED
ASSIGNED
DRAFTING
EVIDENCE_MISSING
REVIEW_REQUIRED
COMPLETE
BLOCKED


16. Proposal Section 상태

EMPTY
DRAFT
IN_REVIEW
REVISION_REQUIRED
APPROVED
LOCKED

⸻
17. 데이터 모델

organizations
users

rfps
rfp_documents
rfp_requirements
evaluation_criteria
submission_rules

bid_projects
bid_project_members

proposal_evidences
evidence_sources
evidence_embeddings

compliance_items

proposal_strategies
proposal_sections
proposal_claims
proposal_claim_evidences

reviews
review_findings

submission_checklists
submission_items

bid_outcomes

⸻
18. 주요 엔티티

Organization
id
name
industry
createdAt


Rfp
id
organizationId
title
issuer
publishedAt
deadline
rawDocumentId
status


RfpRequirement
id
rfpId
code
originalText
page
category
criticality
score
sourceLocation


ProposalEvidence
id
organizationId
type
title
summary
status
sourceId


EvidenceSource
id
type
documentId
page
excerpt
capturedAt


BidProject
id
rfpId
organizationId
status
ownerId
createdAt


ComplianceItem
id
bidProjectId
requirementId
ownerId
sectionId
status
riskLevel


ProposalSection
id
bidProjectId
parentId
title
orderNo
status
content


ProposalClaim
id
sectionId
text
claimType
status


ProposalClaimEvidence
claimId
evidenceId

⸻
19. Evidence 검색

초기:

PostgreSQL
+
pgvector


검색은 하이브리드로 한다.

Keyword Search
+
Embedding Similarity
+
Metadata Filter

⸻
20. 기술 아키텍처

Frontend
Next.js
↓
Backend API
Spring Boot
↓
PostgreSQL + pgvector

        ↘ Object Storage
        ↘ LLM Provider


초기에 Kubernetes / Kafka / Microservice는 필요 없다.
⸻
21. 권장 기술 스택

Backend
- Java 17+
- Spring Boot
- Spring MVC
- JPA 또는 MyBatis
- PostgreSQL
- pgvector
- Flyway
- Bean Validation

Frontend
- Next.js
- TypeScript
- App Router
- Tailwind CSS

AI
- Structured Output
- JSON Schema
- Embedding API
- LLM API

Testing
- JUnit
- Testcontainers
- Playwright

CI
- GitHub Actions
  ⸻
22. 문서 처리 파이프라인

PDF / DOCX
↓
Text Extraction
↓
Page / Heading Segmentation
↓
RFP Parser
↓
JSON Schema Validation
↓
Requirement Normalization
↓
User Review
↓
CONFIRMED

⸻
23. RFP 원문 추적

REQ-0021
↓
Document DOC-001
↓
Page 42
↓
"제안사는 최근 3년..."


UI에서 원문 클릭 시 해당 위치를 보여준다.
⸻
24. 사용자 확인

AI 추출 결과는 바로 확정하지 않는다.

EXTRACTED
↓
REVIEW_REQUIRED
↓
CONFIRMED


특히 Mandatory, 배점, 마감, 제출 형식, 필수 증빙은 사용자가 반드시 확인한다.
⸻
25. MVP

MVP의 목적:

RFP 하나를 넣고 제출 가능한 제안 초안과 Compliance 상태를 만드는 것.

포함:

1. Organization
2. Evidence Bank
3. RFP Upload
4. RFP Parse
5. Compliance Matrix
6. Bid Strategy
7. Proposal Section
8. Reviewer
9. Submission Checklist
10. Outcome
    ⸻
26. MVP 제외

- 나라장터 자동 크롤링
- 자동 입찰
- 전자서명
- 가격 자동 산정
- ERP 연동
- CRM 양방향 동기화
- PowerPoint 완전 자동 디자인
- SharePoint/Drive 대규모 연동
- OCR 자체 엔진
- 멀티모델 오케스트레이션
- Kubernetes
- Kafka
- 모바일 앱
  ⸻
27. 첫 Vertical Slice

RFP 원문 등록
↓
Requirement 추출
↓
Schema Validation
↓
원문 위치 대조
↓
DRAFT
↓
사용자 Confirm
↓
CONFIRMED Requirement
↓
Compliance Matrix 조회

⸻
28. 두 번째 Vertical Slice

Proposal Evidence 등록
↓
Requirement 선택
↓
Evidence 검색
↓
Evidence 매핑
↓
제안 문장 생성
↓
Claim ↔ Evidence 검증
↓
사용자 승인

⸻
29. 세 번째 Vertical Slice

Evaluation Criteria
↓
Bid Strategy
↓
Section Planner
↓
Proposal Draft

⸻
30. API 초안

RFP
POST /api/rfps
POST /api/rfps/{id}/documents
POST /api/rfps/{id}/extract
GET  /api/rfps/{id}/requirements
POST /api/rfp-requirements/{id}/confirm


Evidence
POST /api/evidences
GET  /api/evidences
GET  /api/evidences/search


Bid Project
POST /api/bid-projects
GET  /api/bid-projects/{id}
GET  /api/bid-projects/{id}/compliance


Proposal
POST /api/bid-projects/{id}/strategy
POST /api/bid-projects/{id}/sections
POST /api/proposal-sections/{id}/draft
POST /api/proposal-claims/{id}/approve


Review
POST /api/bid-projects/{id}/review
GET  /api/bid-projects/{id}/findings

⸻
31. JSON Schema

schemas/
rfp.schema.json
rfp-requirement.schema.json
evaluation-criteria.schema.json
proposal-evidence.schema.json
evidence-match.llm.schema.json
proposal-claim.llm.schema.json
proposal-review.schema.json

⸻
32. LLM Output과 Backend Output 분리

LLM:

text
evidenceRefs
reason


Backend:

id
text
evidenceRefs
status
createdAt
approvedBy


LLM에게 ID, 상태, 승인자 같은 시스템 데이터를 만들게 하지 않는다.
⸻
33. AI Evaluation Harness

tests/
ai-eval/
rfp-parse/
mandatory/
scoring/
submission/
unmapped/
evidence/
correct-match/
hallucinated-reference/
proposal/
fabricated-number/
unsupported-claim/
review/
missing-requirement/

⸻
34. Golden Dataset

case-001
RFP:
"최근 3년 이내 공공기관 시스템 구축 실적 3건 이상"

Expected:
criticality = MANDATORY
category = REFERENCE
period = 3 years
minimumCount = 3

⸻
35. 평가 지표

RFP Parse

Requirement Recall
Mandatory Recall
Evaluation Score Accuracy
Submission Rule Recall


특히 Mandatory Recall을 가장 중요하게 본다.

Proposal Generation

Unsupported Claim Rate
Evidence Reference Coverage
Numeric Mutation Rate
Requirement Coverage

⸻
36. 하네스

Incident
↓
Invariant
↓
Guard
↓
Meta Test
↓
CI Gate


예:

Incident
RFP에 "3년 이내 실적"이라고 되어 있는데 AI가 "5년"으로 추출

Invariant
기간/수치 조건은 원문과 동일해야 한다.

Guard
Numeric / Date Constraint Validator

Meta Test
3 → 5로 바꿔 실패 확인

CI Gate
PR merge 차단

⸻
37. CI 구조

Contracts
- JSON Schema
- Docs consistency
- Meta tests

Backend
- Unit
- Integration
- Migration

Frontend
- Typecheck
- Lint
- Build

AI Eval
- 실제 LLM 연결 후

⸻
38. 화면 구성

Dashboard
- 진행 중 제안
- 이번 주 마감
- 위험 프로젝트
- 미완료 Mandatory
- 리뷰 대기
- 최근 Win / Loss

Bid Project

Overview
RFP
Compliance
Strategy
Evidence
Proposal
Review
Submission
Result


RFP Analyzer

좌측: 원문

우측:

Requirements
Evaluation
Submission
Risks


Compliance Matrix

Requirement
Criticality
Score
Owner
Evidence
Section
Status
Risk


Evidence Bank

실적
기술
인력
인증
보안
프로세스
제품


Proposal Editor

┌────────────┬─────────────────────────┬──────────────┐
│ 목차        │ 작성 영역                │ Evidence     │
│            │                         │ Requirement  │
│            │                         │ Review       │
└────────────┴─────────────────────────┴──────────────┘


Review Dashboard

BLOCKER 3
WARN 7
NOTE 12

⸻
39. UX 원칙

Chatbot-first 금지.

메인 UI는 Dashboard, Workspace, Compliance Matrix, Evidence Bank, Proposal Editor, Review Dashboard다.

AI는 필요한 위치에서 동작한다.
⸻
40. 권한

ADMIN
BID_MANAGER
CONTRIBUTOR
REVIEWER
VIEWER

⸻
41. 보안

제안 자료에는 고객명, 가격, 인력 정보, 내부 아키텍처, 인증, 사업 전략, 경쟁사 정보가 포함될 수 있다.

필수 고려:

- 조직 단위 데이터 격리
- 저장 암호화
- 전송 암호화
- 감사 로그
- 파일 접근 제어
- Prompt 로그 관리
- Secret 필터
- AI Provider 데이터 정책 검토
  ⸻
42. Audit Log

Requirement 변경
Evidence 수정
Claim 승인
제안서 수정
제출 상태 변경
사용자 권한 변경

⸻
43. 버전 관리

ProposalVersion
SectionVersion
ClaimVersion


최종 제출 버전을 명확히 저장한다.
⸻
44. 템플릿

Public SI
Private Enterprise
Cloud
Maintenance
Consulting
AI/Data


템플릿은 목차, 섹션 규칙, 문체, 표준 문구, 디자인 참조를 가진다.
⸻
45. 과거 제안 재사용

“문장 복사”가 아니라 Evidence와 패턴을 재사용한다.

과거 제안서
↓
Evidence 추출
↓
Winning Pattern
↓
새 RFP에 재조합

⸻
46. Win / Loss Intelligence

장기적으로 중요한 데이터:

산업/기관 유형
평가 항목
강조한 Evidence
리뷰 지적
최종 결과
고객 피드백

⸻
47. KPI

제품 KPI
- RFP 분석 시간 감소
- Requirement 누락률
- Mandatory 누락률
- Evidence 재사용률
- 초안 작성 시간
- 리뷰 발견 건수
- 제출 준비 시간

비즈니스 KPI
- 활성 Organization
- 월 Bid Project 수
- Paid Seat
- ARR
- Retention
- Expansion Revenue

결과 KPI
- Proposal Win Rate
- Qualified Bid Win Rate

초기에는 Win Rate 자체를 제품 효과로 단정하지 않는다.
⸻
48. 핵심 North Star

Evidence-backed Requirement Coverage

완료된 Requirement 중 근거까지 연결된 Requirement 비율.
⸻
49. 비즈니스 모델

Starter
- 소수 사용자
- 월 RFP 제한
- 기본 AI

Team
- 사용자 확장
- Evidence Bank
- Review
- Export

Enterprise
- SSO
- Private deployment
- Audit
- Custom connector
- Custom model policy

⸻
50. 과금 기준 후보

- Seat
- Organization
- RFP Project
- AI Usage
- Storage

초기에는 Seat + Project 조합이 이해하기 쉽다.
⸻
51. 경쟁 우위

단순 제안서 생성 AI는 쉽게 복제된다.

방어력은 다음에서 나온다.

Company Evidence Graph
+
RFP Requirement History
+
Proposal Decision History
+
Win/Loss Data
+
Review Findings

⸻
52. 장기 Moat

1. Proposal Evidence Graph
2. Requirement Knowledge
3. Win / Loss History
4. Proposal Workflow Lock-in
   ⸻
53. 제품 차별화 문장

A
RFP 요구사항을 빠짐없이 추적하고, 실제 회사 근거만 사용해 제안서를 만드는 AI Proposal OS

B
RFP 분석부터 Compliance, Evidence, 작성, 리뷰, 제출까지 관리하는 AI 제안 운영 서비스

C
근거 없는 제안 문장을 만들지 않고, 요구사항별 대응 상태를 끝까지 추적하는 AI 제안 플랫폼
⸻
54. GitHub Description 후보

영문:

AI Proposal OS for RFP analysis, compliance tracking, evidence-backed proposal writing, review, and submission management.

한국어:

RFP 분석, 요구사항 추적, 근거 기반 제안서 작성, 검토와 제출 준비를 지원하는 AI 제안 운영 서비스
⸻
55. 슬로건 후보

RFP에서 제출까지, 놓치는 요구사항 없이.
Write less. Prove more.
Every claim needs evidence.
제안서는 쓰는 것이 아니라 관리하는 것이다.
수주 제안의 근거와 진행 상태를 한곳에서.

⸻
56. 프로젝트 디렉터리 제안

bidpilot/
│
├── backend/
├── frontend/
│
├── docs/
│   ├── 00-overview/
│   ├── 01-domain/
│   ├── 02-features/
│   ├── 03-architecture/
│   ├── 04-product/
│   └── adr/
│
├── schemas/
├── tools/
├── tests/
│   └── ai-eval/
│
├── .claude/
│   ├── skills/
│   └── agents/
│
└── .github/
└── workflows/

⸻
57. 문서 분리안

docs/00-overview
problem.md
vision.md
principles.md
target-users.md


docs/01-domain
rfp.md
requirement.md
proposal-evidence.md
compliance-matrix.md
proposal-claim.md
glossary.md


docs/02-features
rfp-import.md
rfp-parser.md
evidence-bank.md
bid-decision.md
proposal-strategy.md
section-planner.md
proposal-writer.md
reviewer.md
submission.md
outcome.md


docs/03-architecture
system-architecture.md
ai-orchestration.md
hallucination-policy.md
harness.md
security.md


docs/04-product
mvp.md
roadmap.md
screens.md
kpi.md
business-model.md
demo.md

⸻
58. ADR 후보

ADR-0001 modular monolith로 시작한다
ADR-0002 RFP 원문이 Requirement의 source of truth다
ADR-0003 Generated Claim은 Evidence Reference를 가진다
ADR-0004 Mandatory Requirement는 제출 전 COMPLETE여야 한다
ADR-0005 AI 출력은 schema validation 후 도메인으로 들어간다
ADR-0006 pgvector로 Evidence 검색을 시작한다
ADR-0007 Proposal 상태와 승인 상태는 backend가 소유한다
ADR-0008 AI Draft는 사용자 승인 없이 Final이 될 수 없다

⸻
59. Claude / Coding Agent Harness

루트 CLAUDE.md는 짧게 유지한다.

Product Invariants

1. RFP 원문에 없는 Requirement를 만들지 않는다.
2. Mandatory를 임의로 Optional로 바꾸지 않는다.
3. Evidence 없는 회사 실적 주장을 생성하지 않는다.
4. 수치를 원문과 다르게 쓰지 않는다.
5. AI Draft는 Final 상태를 직접 만들 수 없다.
6. Proposal Claim에는 Evidence Reference가 필요하다.

⸻
60. Claude Skills 후보

.claude/skills/
rfp-parse/
proposal-evidence/
compliance/
proposal-write/
proposal-review/


초기에는 3개 정도만 만든다.
⸻
61. Reviewer Agent

.claude/agents/proposal-domain-reviewer.md


검사:

RFP Requirement 누락
Mandatory downgrade
Evidence 없는 Claim
수치 변경
Evidence Source 누락
AI가 상태/점수 소유
Schema / Docs drift


Read-only.
⸻
62. 첫 Demo 시나리오

1. 공공 IT 시스템 구축 RFP PDF 업로드
2. Requirements / Mandatory / Evaluation / Submission Rules 구조화
3. 회사 Evidence Bank와 자동 매칭
4. 고위험 Mandatory 부족 항목 표시
5. 제안 전략 생성
6. 한 Section 초안 생성
7. 각 문장 Evidence 표시
8. Reviewer가 근거 없는 수치 차단
9. Compliance Matrix 완료
10. Submission Ready

이 시나리오 하나만으로 제품의 차별점을 설명할 수 있다.
⸻
63. 개발 순서

Phase 0  문서 / 도메인 / Schema / ADR
Phase 1  RFP Source + Requirement Extraction
Phase 2  Evidence Bank
Phase 3  Compliance Matrix
Phase 4  Evidence Matching
Phase 5  Proposal Claim Generation
Phase 6  Review Harness
Phase 7  Proposal Workspace UI
Phase 8  Outcome / Win-Loss

⸻
64. 4주 MVP 예시

Week 1
- Repo scaffold
- PostgreSQL/Flyway
- RFP upload
- Raw text 저장
- Requirement schema
- Stub extractor

Week 2
- 실제 LLM RFP extractor
- Requirement review
- Compliance Matrix

Week 3
- Evidence Bank
- Evidence search
- Claim generation
- Evidence ref validation

Week 4
- Proposal editor
- Reviewer
- Submission checklist
- Demo scenario
- CI / AI eval
  ⸻
65. 8주 확장

Week 5~6
- Evaluation Criteria
- Bid Strategy
- Section Planner
- Proposal Review

Week 7
- Export
- PDF / DOCX
- Audit log

Week 8
- Outcome
- Dashboard
- Win/Loss insight
  ⸻
66. 위험 요소

RFP 파싱 정확도
대응:
- source location 필수
- unmapped fragments
- human confirmation
- mandatory recall 측정

문서 형식 다양성
초기에는 텍스트 추출 가능한 PDF 중심. OCR은 후속.

Hallucination
대응:
- Evidence-only
- schema
- source trace
- numeric guard
- reviewer

너무 큰 기능 범위
초기에는 다음만 제대로 만든다.

RFP
→ Requirement
→ Evidence
→ Compliance
→ Claim


회사 데이터 확보
과거 제안서/회사 소개서 업로드 → Evidence 후보 추출 → 사용자 확인 방식으로 해결한다.
⸻
67. 성공 조건

1. RFP PDF에서 Mandatory Requirement를 빠뜨리지 않는다.
2. 각 Requirement를 원문 위치로 추적할 수 있다.
3. 회사 Evidence와 Requirement를 연결할 수 있다.
4. Evidence 없는 주요 제안 주장을 차단한다.
5. Compliance Matrix에서 제출 준비 상태를 확인할 수 있다.
6. 한 개 Proposal Section을 근거 기반으로 생성할 수 있다.

⸻
68. 하지 말아야 할 것

초기에 다음을 만들지 않는다.

"PDF 넣으면 제안서 100페이지 자동 생성"


또한 챗봇만 있는 제품으로 만들지 않는다.

BidPilot의 중심은:

Requirement
Evidence
Compliance
Claim
Review


이다.
⸻
69. 제품의 가장 중요한 문장

제안서는 잘 쓰는 것보다, 요구사항을 빠뜨리지 않고 회사가 실제로 증명할 수 있는 내용을 쓰는 것이 먼저다.

BidPilot은 이 원칙을 제품으로 만든다.
⸻
70. 최종 제품 정의

BidPilot은 RFP와 회사 내부의 실적·인력·기술 자료를 구조화하고, 요구사항별 대응 상태와 근거를 관리하며, 검증 가능한 정보만 사용해 제안 전략과 제안서 초안을 만드는 AI Proposal Operating System이다.
