package comm.geekaca.test.atm;

import java.util.Random;
import java.util.Scanner;

public class ATMSystem {
    public static final int MAIN_LOGIN = 1;
    public static final int MAIN_ENROLL = 2;
    public static final int MAIN_QUIT = 3;
    public static final int USERPAGE_INQUIRE = 1;
    public static final int USERPAGE_SAVE_MONEY = 2;
    public static final int USERPAGE_GET_MONEY = 3;
    public static final int USERPAGE_TRANSFER_MONEY = 4;
    public static final int USERPAGE_CHANGE_PASSWORD = 5;
    public static final int USERPAGE_EXIT = 6;
    public static final int USERPAGE_CANCEL_ACCOUNT = 7;

    public static void main(String[] args) {
        initAccounts();
        Scanner sc = new Scanner(System.in);
        mainPage(sc);
    }

    /**
     * 主界面
     *
     * @param sc
     */
    private static void mainPage(Scanner sc) {

        System.out.println("======欢迎您进入到ATM系统===============");
        while (true) {
            System.out.println("1、登录账户");
            System.out.println("2、注册账户");
            System.out.println("3、退出");
            System.out.println("请您选择操作：");

            //命令
            int command = sc.nextInt();
            switch (command) {
                case MAIN_LOGIN:
                    //登录
                    login(sc);
                    break;
                case MAIN_ENROLL:
                    //注册
                    registered(sc);
                    break;
                case MAIN_QUIT:
                    //退出程序
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入有误！");
                    break;
            }
        }
    }
    /**
     * 登录界面
     *
     * @param sc
     */
    private static void login(Scanner sc) {

        System.out.println("==================欢迎您进入到登录操作======================");

        /**
         * 当用户名密码输入正确，那么继续下一环节：下一个菜单：
         * 选择  取款，存款。。。。
         *
         * 如果用户名或密码错误，那么要继续提示用户输入
         */
        while (true) {
            System.out.println("请输入卡号：");
            String cardNo = sc.next();
            System.out.println("请输入密码：");
            String passwd = sc.next();
            /**
             * 判断卡号和密码是否正确
             */
            final boolean[] isRight = {false};
            AccountMap.getAccountMap().forEach((cardid,accounts)->{
                Account accTemp = AccountMap.getAccountMap().get(cardid);
                if ((accTemp.getCardId().equals(cardNo)) && (accTemp.getPassWord().equals(passwd))) {
                    System.out.println("欢迎" + accTemp.getUserName() + "先生/女士，进入系统，现在可以开始办理业务了");
                    isRight[0] = true;
                    //进入用户操作页，查询 存取 等
                    userPage(accTemp);
                    return ;
                }
            });

            if (!isRight[0]) {
                System.out.println("账号或密码错误,请再次输入");
            }
        }
    }

    /**
     * 注册界面
     *
     * @param sc 键盘输入
     */
    private static void registered(Scanner sc) {


        System.out.println("================欢迎进入开户操作================");
        Account account = new Account();
        System.out.println("请输入账户名称：");
        String userName = sc.next();
        account.setUserName(userName);
        while (true) {
            System.out.println("请输入密码：");
            String password = sc.next();
            System.out.println("请输入确认密码：");
            String passwordConfirm = sc.next();
            if (passwordConfirm.equals(password)) {
                account.setPassWord(password);
                break;
            } else {
                System.out.println("两次密码不相同");
            }
        }
        System.out.println("请设置取现额度：");
        int quotaMoney = sc.nextInt();
        if (quotaMoney > 0) {
            account.setQuotaMoney(quotaMoney);
        } else {
            System.out.println("输入金额错误");
        }
        Random random = new Random();
        final String[] cardId = {""};
        final boolean[] isReat = {true};
        while (true) {
            for (int i = 0; i < 8; i++) {
                cardId[0] += random.nextInt(10);
            }
            AccountMap.getAccountMap().forEach((cardid,accounts)->{
                Account accTemp = AccountMap.getAccountMap().get(cardid);
                if (cardId[0].equals(accTemp.getCardId())) {
                    cardId[0] = "";//重置，不重置会残留之前的卡号，导致位数变多
                    //break;
                } else {
                    account.setCardId(cardId[0]);
                    isReat[0] = false;
                }
            });
            if (!isReat[0]) {
                break;
            }
        }
        AccountMap.getAccountMap().put(cardId[0],account);
        System.out.println("恭喜您开户完成，你的卡号为：" + cardId[0]);
    }

    /**
     * 初始化两个账户
     */
    private static void initAccounts() {
        Account account = new Account();
        account.setUserName("张三");
        account.setPassWord("abc123");
        account.setCardId("987654321");
        account.setQuotaMoney(4000);
        //AccountList.getList().add(account);
        AccountMap.getAccountMap().put(account.getCardId(), account);

        Account account2 = new Account();
        account2.setUserName("李四");
        account2.setPassWord("111111");
        account2.setCardId("123456");
        account2.setMoney(5000);
        account2.setQuotaMoney(30000);
        //AccountList.getList().add(account2);
        AccountMap.getAccountMap().put(account2.getCardId(), account2);
    }

    /**
     * 用户界面
     *
     * @param acc 登录的账户
     */

    private static void userPage(Account acc) {
        System.out.println("======欢迎您进入到ATM系统===============");
        while (true) {
            System.out.println("***********************");
            System.out.println("1、查询");
            System.out.println("2、存款");
            System.out.println("3、取款");
            System.out.println("4、转账");
            System.out.println("5、修改密码");
            System.out.println("6、退出");
            System.out.println("7、注销账户");
            System.out.println("***********************");
            System.out.println("请您选择操作：");
            Scanner sc = new Scanner(System.in);
            //命令
            int command = sc.nextInt();
            switch (command) {
                case USERPAGE_INQUIRE:
                    //查询
                    showInfo(acc);
                    break;
                case USERPAGE_SAVE_MONEY:
                    //存款
                    System.out.println("=======存款操作=======");
                    while (true) {
                        System.out.println("请输入存款金额：");
                        double saveMoney = sc.nextDouble();
                        if (saveMoney <= 0) {
                            System.out.println("输入有误");
                        } else {
                            acc.setMoney(acc.getMoney() + saveMoney);
                            System.out.println("存款成功");
                            showInfo(acc);
                            break;
                        }
                    }
                    break;

                case USERPAGE_GET_MONEY:
                    //取款
                    System.out.println("=======取款操作=======");
                    while (true) {
                        System.out.println("请输入取款金额：");
                        double loadMoeny = sc.nextDouble();
                        if (loadMoeny <= 0) {
                            System.out.println("输入有误");
                            return;
                        } else if (loadMoeny > acc.getMoney()) {
                            System.out.println("余额不足");

                        } else if (loadMoeny > acc.getQuotaMoney()) {
                            System.out.println("超过限额");
                        } else {
                            acc.setMoney(acc.getMoney() - loadMoeny);
                            System.out.println("取款成功");
                            showInfo(acc);
                            break;
                        }
                    }
                    break;
                case USERPAGE_TRANSFER_MONEY:
                    //转账
                    transferMoney(acc, sc);
                    break;
                case USERPAGE_CHANGE_PASSWORD:
                    //修改密码
                    System.out.println("=======修改密码=======");
                    while (true) {
                        System.out.println("请输入新密码");
                        String password = sc.next();
                        System.out.println("请输入确认密码：");
                        String passwordConfirm = sc.next();
                        if (passwordConfirm.equals(password)) {
                            acc.setPassWord(password);
                            break;
                        } else {
                            System.out.println("两次密码不相同");
                        }
                    }
                    mainPage(sc);
                    break;
                case USERPAGE_EXIT:
                    //退出
                    mainPage(sc);
                    return;
                case USERPAGE_CANCEL_ACCOUNT:
                    //注销
                    AccountMap.getAccountMap().remove(acc.getCardId());
                    if (!AccountMap.getAccountMap().containsKey(acc.getCardId())) {
                        System.out.println("账户已注销");
                    } else {
                        System.out.println("注销失败");
                    }

                    return;

                default:
                    System.out.println("输入有误！");
                    break;
            }
        }
    }

    /**
     * 显示账户信息
     *
     * @param acc
     */
    private static void showInfo(Account acc) {
        System.out.println("=======您当前账户信息如下=======");
        System.out.println("卡号：" + acc.getCardId());
        System.out.println("户主：" + acc.getUserName());
        System.out.println("余额：" + acc.getMoney());
        System.out.println("取现额度：" + acc.getQuotaMoney());
        System.out.println("============================");
    }

    /**
     * 转账
     *
     * @param acc 你的账号
     * @param sc  键盘输入
     *            str.startsWith("a");
     */
    private static void transferMoney(Account acc, Scanner sc) {
        System.out.println("=======转账操作=======");
        while (true) {
            if (AccountMap.getAccountMap().size() <= 1) {
                System.out.println("只有一个账号");
                return;
            }
            System.out.println("请输入对方卡号：");
            String cardID = sc.next();
            AccountMap.getAccountMap().forEach((cardid,accounts)->{
                Account accTemp = AccountMap.getAccountMap().get(cardid);
                if (accTemp.getCardId().equals(cardID)) {
                    String tempName = accTemp.getUserName().substring(1);

                    System.out.println("请输入【*" + tempName + "】的姓氏来确认:");
                    String nameInput = sc.next();

                    if ((nameInput + tempName).equals(accTemp.getUserName())) {
                        System.out.println("请您输入转账的金额（您最多可以转账：" + acc.getMoney() + "元）");
                        double tranMoney = sc.nextDouble();

                        if ((tranMoney > acc.getMoney()) || (tranMoney < 0)) {
                            System.out.println("金额输入错误");
                        } else {
                            acc.setMoney(acc.getMoney() - tranMoney);
                            accTemp.setMoney(accTemp.getMoney() + tranMoney);
                            System.out.println("转账成功");
                            showInfo(acc);
                            return;
                        }
                    } else {
                        System.out.println("姓氏输入错误");
                        return;
                    }
                } else {
                    System.out.println("对方账号不存在");
                    return;
                }
            });
        }
    }
}
